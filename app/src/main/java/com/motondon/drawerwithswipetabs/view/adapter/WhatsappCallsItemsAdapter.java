package com.motondon.drawerwithswipetabs.view.adapter;

import android.content.Context;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.motondon.drawerwithswipetabs.R;
import com.pkmmte.view.CircularImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WhatsappCallsItemsAdapter extends RecyclerView.Adapter<WhatsappCallsItemsAdapter.ViewHolder> {

    private Context mContext;
    private List<Pair<String, Integer>> mCallsList;

    public WhatsappCallsItemsAdapter(Context context, List<Pair<String, Integer>> callsItemList) {
        mContext = context;
        mCallsList = callsItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(mContext)
                .inflate(R.layout.item_whatsapp_calls, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mCallAvatar.setImageResource(mCallsList.get(position).second);
        holder.mCallAvatar.setScaleType(ImageView.ScaleType.FIT_XY);

        holder.mText1.setText(mCallsList.get(position).first);
        holder.mText2.setText("12/31/16, 9:03 PM");

    }

    @Override
    public int getItemCount() {
        return mCallsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.call_avatar)
        CircularImageView mCallAvatar;
        @BindView(R.id.call_name)  TextView mText1;
        @BindView(R.id.call_time) TextView mText2;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
