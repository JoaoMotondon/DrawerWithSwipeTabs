package com.motondon.drawerwithswipetabs.view.activity;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.motondon.drawerwithswipetabs.R;
import com.motondon.drawerwithswipetabs.view.fragment.help.HelpFragment;
import com.motondon.drawerwithswipetabs.view.fragment.single.LinkedInFragment;
import com.motondon.drawerwithswipetabs.view.fragment.single.YouTubeFragment;
import com.motondon.drawerwithswipetabs.view.fragment.tab.NewsFragment;
import com.motondon.drawerwithswipetabs.view.fragment.tab.WhatsAppFragment;
import com.pkmmte.view.CircularImageView;

/**
 * This project is intended to demonstrate how to create an app using Material Design Navigation Drawer and TabLayout. Basically
 * it creates a simple navigation drawer and depends on which item is clicked, it will either open a tab layout with some fragments
 * or a simple fragment.
 *
 */
public class MainActivity extends AppCompatActivity {

    private static String STATE_SELECTED_POSITION = "STATE_SELECTED_POSITION";

    private DrawerLayout mDrawerLayout;

    // This is the navigation drawer itself.
    private NavigationView mNavigationView;

    // Used to show a animated toggle button in the toolbar.
    private ActionBarDrawerToggle mDrawerToggle;

    // This is the toolbar which will replace default action bar, so that will be possible for the navigation drawer to
    // slide over it when it is open.
    private Toolbar mToolbar;

    // Used to restore navigation drawer selected menu during orientation change.
    // See this link for details: http://blog.grafixartist.com/easy-navigation-drawer-with-design-support-library/
    private Integer mCurrentSelectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Since we store navigation drawer selected menu item in onSaveInstanceState() method, we need to check whether it was already
        // saved here (i.e.: savedInstanceState != null) and store it. So that if user does not change any item, we still have a reference
        // to it in case of an orientation change.
        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
        }

        // In order to slide our navigation drawer over the ActionBar, we need to use the new Toolbar widget as defined in
        // the AppCompat v21 library
        // To use the Toolbar as an ActionBar, we need first disable the default ActionBar. This can be done by setting the app
        // theme in styles.xml file. Otherwise we are likely to see a java.lang.IllegalStateException with an error message that
        // reads: "This Activity already has an action bar supplied by the window decor...".
        // We defined this toolbar in a separate xml file only for the sake of clarity.
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nvView);

        // By default there is not a hamburger animation icon in the toolbar. So, if we want it, we must set it up manually.
        // This is what the method below does.
        setupDrawerToggle();

        // Now add a listener to the NavigationView view, so that it can handle user actions.
        setupDrawerContent(mNavigationView);

        // Setup navigation drawer header information such as profile image, name and e-mail
        setupProfileInformation();

        // Set it as the default item checked
        Menu menu = mNavigationView.getMenu();
        MenuItem item = menu.findItem(R.id.nav_youtube_fragment);
        item.setChecked(true);
        selectDrawerItem(item);
    }

    /**
     * This method is intended to demonstrate how to access navigation drawer header information and manipulate them.
     *
     * For this example, we add an image to the profile imageView, set a name and an e-mail. Also we add a listener to the
     * e-mail view so that we can call an external e-mail app to send an e-mail to that person.
     */
    private void setupProfileInformation() {
        // Lines below demonstrate on how to get a reference for navigation drawer header text views and change them
        View hView =  mNavigationView.getHeaderView(0);
        CircularImageView nav_image = (CircularImageView) hView.findViewById(R.id.profile_image);
        nav_image.setImageResource(R.drawable.john_lennon_photo);
        nav_image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        TextView nav_user = (TextView)hView.findViewById(R.id.name);
        nav_user.setText("John Lennon");
        final TextView nav_email = (TextView)hView.findViewById(R.id.email);
        nav_email.setText("john.lenon@gmail.com");

        nav_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawers();
                // TODO: Here we could call an Intent.ACTION_SEND to call an external app to send an email.
                Snackbar.make(mDrawerLayout, "E-mail to " + nav_email.getText().toString() + " sent successfully", Snackbar.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * In order to have animation on the hamburger icon (to indicate the drawer is being opened and closed), we need to use
     * the ActionBarDrawerToggle class.
     *
     * See link below for details:
     * http://stackoverflow.com/questions/26754940/appcompatv7-v21-navigation-drawer-not-showing-hamburger-icon
     *
     * Also, when using the ActionBarDrawerToggle, you must call it during onPostCreate() and onConfigurationChanged(). See these methods
     * for details
     *
     * Although we do not do any action after a drawer is opened or closed, this code demonstrate how to handle these events. Maybe it can
     * be useful in future days.
     *
     */
    private void setupDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,  R.string.drawer_close) {
            // Called when a drawer has settled in a completely closed state.
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //getActionBar().setTitle(mTitle);
                //invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            // Called when a drawer has settled in a completely open state.
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getActionBar().setTitle(mDrawerTitle);
                //invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);

        // Add drawer toggle to the drawer layout listener.
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    /**
     * Set all the required listeners for the navigation drawer menu items. Note we have a custom item (SwitchCompact view), so
     * we have to add a separate listener for its clicks.
     *
     * @param navigationView
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });
    }

    private void selectDrawerItem(MenuItem item) {
        Fragment fragment = null;
        Class fragmentClass;

        switch (item.getItemId()) {
            case R.id.nav_youtube_fragment:
                mCurrentSelectedPosition = 0;
                // Highlight the selected item has been done by NavigationView
                item.setChecked(true);

                fragmentClass = YouTubeFragment.class;
                break;

            case R.id.nav_linkedin_fragment:
                mCurrentSelectedPosition = 1;
                // Highlight the selected item has been done by NavigationView
                item.setChecked(true);

                fragmentClass = LinkedInFragment.class;
                break;

            case R.id.nav_tab_news_fragment:
                mCurrentSelectedPosition = 2;
                // Highlight the selected item has been done by NavigationView
                item.setChecked(true);

                fragmentClass = NewsFragment.class;
                break;

            case R.id.nav_tab_whatsapp_fragment:
                mCurrentSelectedPosition = 2;
                // Highlight the selected item has been done by NavigationView
                item.setChecked(true);

                fragmentClass = WhatsAppFragment.class;
                break;

            case R.id.nav_help_fragment:
                mCurrentSelectedPosition = 4;
                Snackbar.make(mDrawerLayout, "You clicked on the Help menu item", Snackbar.LENGTH_SHORT).show();
                fragmentClass = HelpFragment.class;
                break;

            default:
                fragmentClass = YouTubeFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, fragment).commit();


        // Set action bar title
        setTitle(item.getTitle());

        // Close the navigation drawer
        mDrawerLayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // `onPostCreate` called when activity start-up is complete after `onStart()`
    // NOTE! Make sure to override the method with only a single `Bundle` argument
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION, -1);

        if (mCurrentSelectedPosition > -1) {
            Menu menu = mNavigationView.getMenu();
            menu.getItem(mCurrentSelectedPosition).setChecked(true);
        }
    }
}

