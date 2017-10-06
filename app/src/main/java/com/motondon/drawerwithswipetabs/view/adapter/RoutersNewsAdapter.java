package com.motondon.drawerwithswipetabs.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.motondon.drawerwithswipetabs.R;
import com.motondon.drawerwithswipetabs.view.fragment.tab.NewsFeedsFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RoutersNewsAdapter extends RecyclerView.Adapter<RoutersNewsAdapter.ViewHolder>{

    private List<NewsFeedsFragment.News> news = new ArrayList<>();
    private Context context;

    public RoutersNewsAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<NewsFeedsFragment.News> newImages) {
        news = newImages;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_routers_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String imageUrl = news.get(position).imageUrl;

        Picasso.with(context).load(imageUrl).error(context.getDrawable(R.drawable.no_cover)).into(holder.image);

        holder.newsTitle.setText(news.get(position).newsTitle);
        holder.newsDetails.setText(news.get(position).newsDetails);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView newsTitle;
        private TextView newsDetails;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.news_image);
            newsTitle = (TextView) itemView.findViewById(R.id.news_title);
            newsDetails = (TextView) itemView.findViewById(R.id.news_details);
        }
    }
}