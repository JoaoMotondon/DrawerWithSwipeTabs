package com.motondon.drawerwithswipetabs.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.motondon.drawerwithswipetabs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsImageAdapter extends RecyclerView.Adapter<NewsImageAdapter.ViewHolder>{

    private List<String> images = new ArrayList<>();
    private Context context;

    public NewsImageAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> newImages) {
        images = newImages;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String imageUrl = images.get(position);

        Picasso.with(context).load(imageUrl).error(context.getDrawable(R.drawable.no_cover)).into(holder.cover);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView cover;

        public ViewHolder(View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}