package com.example.driveit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.driveit.R;
import com.example.driveit.model.ModelHome;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ModelHome> menusList;
    private Context mContext;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public HomeAdapter(Context mContext, List<ModelHome> menusList) {
        this.mContext = mContext;
        this.menusList = menusList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View viewList = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_list, parent, false);
            //inflate your layout and pass it to view holder
            return new HomeListViewHolder(viewList);
        } else if (viewType == TYPE_HEADER) {
            View viewHeader = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_header, parent, false);
            //inflate your layout and pass it to view holder
            return new HomeHeaderViewHolder(viewHeader);
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HomeListViewHolder) {
            ModelHome menus = menusList.get(position);
            ((HomeListViewHolder) holder).objectTitle.setText(menus.getObjectTitle());
            ((HomeListViewHolder) holder).objectPrice.setText(menus.getObjectPrice());
            ((HomeListViewHolder) holder).objectDuration.setText(menus.getObjectDuration());
            ((HomeListViewHolder) holder).objectImage.setImageResource(menus.getObjectImage());

        } else if (holder instanceof HomeHeaderViewHolder) {
            //cast holder to VHHeader and set data for header.
        }
    }

    @Override
    public int getItemCount() {
        return menusList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private ModelHome getItem(int position) {
        return menusList.get(position);
    }


    public static class HomeListViewHolder extends RecyclerView.ViewHolder {
        ImageView objectImage;
        TextView objectTitle, objectDuration, objectPrice;

        public HomeListViewHolder(@NonNull View itemView) {
            super(itemView);
           /* objectTitle = (TextView) itemView.findViewById(R.id.object_title);
            objectDuration = (TextView) itemView.findViewById(R.id.object_duration);
            objectPrice = (TextView) itemView.findViewById(R.id.object_price);
            objectImage = (ImageView) itemView.findViewById(R.id.object_image);*/
        }
    }

    public static class HomeHeaderViewHolder extends RecyclerView.ViewHolder {
        public HomeHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
