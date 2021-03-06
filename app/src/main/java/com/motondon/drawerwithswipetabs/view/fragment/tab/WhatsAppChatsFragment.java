package com.motondon.drawerwithswipetabs.view.fragment.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.motondon.drawerwithswipetabs.R;
import com.motondon.drawerwithswipetabs.view.adapter.WhatsappChatsItemsAdapter;

import java.util.Collections;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WhatsAppChatsFragment extends Fragment {


    @BindView(R.id.rv_chat_message_list) RecyclerView whatsappChatMessagesList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_whatsapp_chats, container, false);

        ButterKnife.bind(this, root);

        whatsappChatMessagesList.setHasFixedSize(true);
        whatsappChatMessagesList.setLayoutManager(new LinearLayoutManager(getContext()));

        // Randomize names list just for fun
        long seed = System.nanoTime();
        Collections.shuffle(WhatsAppFragment.namesList, new Random(seed));

        whatsappChatMessagesList.setAdapter(new WhatsappChatsItemsAdapter(getContext(), WhatsAppFragment.namesList));

        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.whatsapp_chats_menu, menu);
    }
}
