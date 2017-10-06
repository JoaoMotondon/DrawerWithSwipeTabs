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


public class WhatsappChatsItemsAdapter extends RecyclerView.Adapter<WhatsappChatsItemsAdapter.ViewHolder> {

    private Context mContext;
    private List<Pair<String, Integer>> mChatsList;

    public WhatsappChatsItemsAdapter(Context context, List<Pair<String, Integer>> chatsList) {
        mContext = context;
        mChatsList = chatsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(mContext)
                .inflate(R.layout.item_whatsapp_chats, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        // Just add the same image for the sake of simplicity.
        holder.mChatsAvatar.setImageResource(mChatsList.get(position).second);
        holder.mChatsAvatar.setScaleType(ImageView.ScaleType.FIT_XY);

        holder.mText1.setText(mChatsList.get(position).first);
        holder.mText2.setText("This is just a sample message");
    }

    @Override
    public int getItemCount() {
        return mChatsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.contact_avatar) CircularImageView mChatsAvatar;
        @BindView(R.id.contact_name)  TextView mText1;
        @BindView(R.id.last_message) TextView mText2;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
