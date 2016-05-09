package com.qtfreet.beautyleg.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qtfreet.beautyleg.R;
import com.qtfreet.beautyleg.ui.App;
import com.qtfreet.beautyleg.ui.adapter.FragmentAdapter;

import com.qtfreet.beautyleg.ui.fragment.GirlFragment;
import com.qtfreet.beautyleg.utils.Utils;
import com.qtfreet.beautyleg.wiget.ActionSheetDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.title_name)
    TextView toolbarTitle;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.tab)
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        App.getInstance().addActivity(MainActivity.this);
    }

    private void initData() {

        List<String> titles = new ArrayList<>();
        titles.add("秀人网");
        titles.add("BeautyLeg");
        titles.add("ROSI");
        titles.add("AISS");
        titles.add("BOLUOLI");
        titles.add("丝宝");
        titles.add("丝间");
        titles.add("推女郎");
        titles.add("尤果");


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(GirlFragment.newFragment(GirlFragment.XIUREN));
        fragments.add(GirlFragment.newFragment(GirlFragment.BL));
        fragments.add(GirlFragment.newFragment(GirlFragment.ROSI));
        fragments.add(GirlFragment.newFragment(GirlFragment.AISS));
        fragments.add(GirlFragment.newFragment(GirlFragment.BOLUOLI));
        fragments.add(GirlFragment.newFragment(GirlFragment.SIBAO));
        fragments.add(GirlFragment.newFragment(GirlFragment.SIJIAN));
        fragments.add(GirlFragment.newFragment(GirlFragment.TUI));
        fragments.add(GirlFragment.newFragment(GirlFragment.YOUGUO));


        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(3)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(4)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(5)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(6)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(7)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(8)));

        viewPager.setOffscreenPageLimit(3);

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragments, titles));
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initView() {
        ButterKnife.bind(this);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (toolbarTitle != null) {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                toolbarTitle.setText(R.string.main_title);
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        ImageView header = (ImageView) headerView.findViewById(R.id.header_view);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ActionSheetDialog(MainActivity.this)
                        .builder()
                        .setTitle(getString(R.string.change_header))
                        .setCancelable(false)
                        .setCanceledOnTouchOutside(false).addSheetItem(getString(R.string.take_pic), ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(MainActivity.this, "该功能并没有实现=。=", Toast.LENGTH_SHORT).show();
                    }
                }).addSheetItem(getString(R.string.take_from_pic), ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(MainActivity.this, "该功能并没有实现=。=", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //捕获返回键按下的事件
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Utils.showDialog(this, "确定要退出了吗?");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.setting) {
//            startActivity(SettingActivity.class);
            Toast.makeText(MainActivity.this, "该功能并没有实现=。=", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
}
