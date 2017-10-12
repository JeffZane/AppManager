package com.awoeems.amg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.awoeems.appinfos.DetailActivity;
import com.awoeems.appinfos.DetailFragment;
import com.awoeems.appinfos.MainCallbacks;
import com.awoeems.appinfos.MainListFragment;
import com.awoeems.baselib.BaseActivity;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainCallbacks {
    //    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private MainListFragment mMainListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        ImageView ivMenu = (ImageView) findViewById(R.id.iv_menu);
        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mMainListFragment = MainListFragment.newInstance();
        getFragmentManager().beginTransaction().add(R.id.fl_content, mMainListFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        mToolbar.setTitle(R.string.app_name);
//        mDrawerLayout.closeDrawer(GravityCompat.START);
//
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//        if (id == R.id.nav_user_apps) {
//            mMainListFragment.switchAppList(MainLoader.TYPE_USER_APPS);
//            mToolbar.setTitle(R.string.label_user_apps);
//        } else if (id == R.id.nav_system_apps) {
//            mMainListFragment.switchAppList(MainLoader.TYPE_SYSTEM_APPS);
//            mToolbar.setTitle(R.string.label_system_apps);
//        } else if (id == R.id.nav_favorite_apps) {
//
//            mToolbar.setTitle(R.string.label_favorite_apps);
//        } else if (id == R.id.nav_share_app) {
//
//        } else if (id == R.id.nav_feedback) {
//
//        } else if (id == R.id.nav_setting) {
//
//        }
        return true;
    }

    @Override
    public void onItemSelected(String packageName) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailFragment.EXTRA_PACKAGE_NAME, packageName);
        startActivity(intent);
    }
}
