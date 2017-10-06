package com.motondon.drawerwithswipetabs.view.fragment.tab;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
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

public class NewsFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_news, container, false);

        viewPager = (ViewPager) root.findViewById(R.id.tabanim_viewpager);

        AppBarLayout appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.app_bar);
        appBarLayout.setElevation(0);

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
        window.setStatusBarColor(Color.parseColor("#ed8b00"));

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#fdbb30"));
        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(colorDrawable);

        AppBarLayout appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.app_bar);
        appBarLayout.setBackgroundColor(Color.parseColor("#fdbb30"));

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tabanim_tabs);
        tabLayout.setBackgroundColor(Color.parseColor("#fdbb30"));
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
        adapter.addFrag(new NewsFeedsFragment(), "Reuters News");
        adapter.addFrag(new NewsImagesFragment(), "Images");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.news_main_menu, menu);
    }
}
