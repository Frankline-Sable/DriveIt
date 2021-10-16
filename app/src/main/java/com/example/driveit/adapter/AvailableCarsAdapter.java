package com.example.driveit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.driveit.R;
import com.example.driveit.model.ModelHome;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class AvailableCarsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_VIEW_TYPE_HEADER = 0;
    private static final int ITEM_VIEW_TYPE_EMPTY = 1;
    private static final int ITEM_VIEW_TYPE_ITEM = 2;
    private Context mContext;

    private final List<ModelHome> mModelList;

    public AvailableCarsAdapter(Context mContext, List<ModelHome> mModelList) {
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
            View headerView = inflater.inflate(R.layout.layout_available_header, parent, false);
            return new HomeHeaderViewHolder(headerView);
        }else  if (viewType == ITEM_VIEW_TYPE_EMPTY) {
            View emptyView = inflater.inflate(R.layout.layout_available_empty, parent, false);

            return new EmptyViewHolder(emptyView);
        }

        View cellView = inflater.inflate(R.layout.layout_home_list, parent, false);
        return new HomeListViewHolder(cellView);
    }

    @Override
    public int getItemViewType(int position) {
        int val;
        if(position==0)
            val=ITEM_VIEW_TYPE_HEADER;
        else if(position==1)
            val=ITEM_VIEW_TYPE_EMPTY;
        else
            val=ITEM_VIEW_TYPE_ITEM;
        return val;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, int position) {
        if (isHeader(position)) {


            return;
        }else if(position==1)
            return;


        final ModelHome model = mModelList.get(position - 1); // Subtract 1 for header

        AvailableCarsAdapter.HomeListViewHolder holder = (AvailableCarsAdapter.HomeListViewHolder) h;
        ((AvailableCarsAdapter.HomeListViewHolder) holder).objectTitle.setText(model.getTitle());

        ((AvailableCarsAdapter.HomeListViewHolder) holder).objectDuration.setText(model.getDuration());
        ((AvailableCarsAdapter.HomeListViewHolder) holder).durationTag.setText(model.getDuration());
        ImageView vw = ((AvailableCarsAdapter.HomeListViewHolder) holder).objectImage;


        NumberFormat formatter = new DecimalFormat("#,###");
        ((AvailableCarsAdapter.HomeListViewHolder) holder).objectPrice.setText(String.format("AED %s", formatter.format(model.getPrice())));

        Glide.with(mContext)
                .load(model.getImage())
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(vw);
    }

    @Override
    public int getItemCount() {
        return mModelList.size() + 2; // add one for the header
    }

    public static class HomeListViewHolder extends RecyclerView.ViewHolder {
        ImageView objectImage;
        TextView objectTitle, objectDuration, objectPrice,durationTag;

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
        public HomeHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public static class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
