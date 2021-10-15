package com.example.driveit.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.driveit.AvailableCars;
import com.example.driveit.Home;
import com.example.driveit.LoginActivity;
import com.example.driveit.R;
import com.example.driveit.model.ModelHome;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_VIEW_TYPE_HEADER = 0;
    private static final int ITEM_VIEW_TYPE_ITEM = 1;
    private Context mContext;

    private final List<ModelHome> mModelList;

    public HomeAdapter(Context mContext, List<ModelHome> mModelList) {
        this.mModelList = mModelList;
        this.mContext = mContext;
    }

    public boolean isHeader(int position) {
        return position == 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == ITEM_VIEW_TYPE_HEADER) {
            View headerView = inflater.inflate(R.layout.layout_home_header, parent, false);
            return new HomeHeaderViewHolder(headerView);
        }

        View cellView = inflater.inflate(R.layout.layout_home_list, parent, false);
        return new HomeListViewHolder(cellView);
    }

    @Override
    public int getItemViewType(int position) {
        return isHeader(position) ? ITEM_VIEW_TYPE_HEADER : ITEM_VIEW_TYPE_ITEM;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, int position) {
        if (isHeader(position)) {
            HomeHeaderViewHolder holder = (HomeHeaderViewHolder) h;
            holder.buttonAvailable.setOnClickListener(v -> {
                mContext.startActivity(new Intent(mContext, AvailableCars.class));

            });
            return;
        }

        final ModelHome model = mModelList.get(position - 1); // Subtract 1 for header

        HomeListViewHolder holder = (HomeListViewHolder) h;
        ((HomeListViewHolder) holder).objectTitle.setText(model.getTitle());
        ((HomeListViewHolder) holder).objectPrice.setText(model.getPrice());
        ((HomeListViewHolder) holder).objectDuration.setText(model.getDuration());
        ((HomeListViewHolder) holder).durationTag.setText(model.getDuration());
        ImageView vw = ((HomeListViewHolder) holder).objectImage;


        Glide.with(mContext)
                .load(model.getImage())
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(vw);
    }

    @Override
    public int getItemCount() {
        return mModelList.size() + 1; // add one for the header
    }

    public static class HomeListViewHolder extends RecyclerView.ViewHolder {
        ImageView objectImage;
        TextView objectTitle, objectDuration, objectPrice, durationTag;

        public HomeListViewHolder(@NonNull View itemView) {
            super(itemView);
            objectTitle = (TextView) itemView.findViewById(R.id.object_title);
            objectDuration = (TextView) itemView.findViewById(R.id.object_duration);
            durationTag = (TextView) itemView.findViewById(R.id.duration_tag);
            objectPrice = (TextView) itemView.findViewById(R.id.object_pricing);
            objectImage = (ImageView) itemView.findViewById(R.id.object_image);
        }
    }

    public static class HomeHeaderViewHolder extends RecyclerView.ViewHolder {
        Button buttonAvailable;

        public HomeHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonAvailable = itemView.findViewById(R.id.buttonAvailable);
        }
    }

}
