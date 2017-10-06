package com.motondon.drawerwithswipetabs.view.fragment.tab;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.motondon.drawerwithswipetabs.R;
import com.motondon.drawerwithswipetabs.view.adapter.ViewPagerAdapter;

import java.util.Arrays;
import java.util.List;

public class WhatsAppFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static List<Pair<String, Integer>> namesList = Arrays.asList(
            new Pair<>("Larry Parker", R.drawable.boy),
            new Pair<>("Amy Russell", R.drawable.girl1),
            new Pair<>("Julia Davis", R.drawable.girl),
            new Pair<>("Martin Lopez", R.drawable.man),
            new Pair<>("Julie Parker", R.drawable.girl2),
            new Pair<>("Anne Patterson", R.drawable.girl3),
            new Pair<>("Christine Turner", R.drawable.girl4),
            new Pair<>("Gregory James", R.drawable.man),
            new Pair<>("Louis Robinson", R.drawable.boy),
            new Pair<>("Janet Butler", R.drawable.girl3));
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_whatsapp, container, false);

        AppBarLayout appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.app_bar);
        appBarLayout.setElevation(0);

        viewPager = (ViewPager) root.findViewById(R.id.tabanim_viewpager);

        // Defines the number of tabs by setting appropriate fragment and tab name and also adds a custom adapter class
        // which provides fragments (required for the view pager)
        setupViewPager(viewPager);

        // Assigns the ViewPager to TabLayout
        tabLayout = (TabLayout) root.findViewById(R.id.tabanim_tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupTabListener();

        changeColor(root);

        return root;
    }

    private void changeColor(View root) {

        Window window = getActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#075e54"));

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#128c7e"));
        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(colorDrawable);

        AppBarLayout appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.app_bar);
        appBarLayout.setBackgroundColor(Color.parseColor("#128c7e"));

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tabanim_tabs);
        tabLayout.setBackgroundColor(Color.parseColor("#128c7e"));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.whatsapp_main_menu, menu);
    }

    private void setupTabListener() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
             viewPager.setCurrentItem(tab.getPosition());

                /*switch (tab.getPosition()) {
                    case 0:
                        Snackbar.make(mCoordinationLayout, "One", Snackbar.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Snackbar.make(mCoordinationLayout, "Two", Snackbar.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Snackbar.make(mCoordinationLayout, "Three", Snackbar.LENGTH_SHORT).show();
                        break;
                }*/
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {

        // Do not forget to use getChildFragmentManager() instead of getFragmentManager(), since this class is already a
        // fragment and we want to add child fragment in it.
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new WhatsAppCallsFragment(), "Calls");
        adapter.addFrag(new WhatsAppChatsFragment(), "Chats");
        adapter.addFrag(new WhatsAppContactsFragment(), "Contacts");
        viewPager.setAdapter(adapter);
    }
}
