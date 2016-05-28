package com.qtfreet.beautyleg.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.qtfreet.beautyleg.R;
import com.qtfreet.beautyleg.data.bean.ImageUrlList;
import com.qtfreet.beautyleg.ui.App;
import com.qtfreet.beautyleg.ui.adapter.GirlDetailAdapter;
import com.qtfreet.beautyleg.ui.adapter.OnMeiziClickListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by qtfreet00 on 2016/5/6.
 */
public class GirlDetailActivity extends AppCompatActivity implements OnMeiziClickListener {
    private RecyclerView recyclerView;
    private GirlDetailAdapter girlDetailAdapter;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.girl_content_layout);
        App.getInstance().addActivity(GirlDetailActivity.this);
        init();
        load();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void load() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        girlDetailAdapter = new GirlDetailAdapter(this, ImageUrlList.url);
        girlDetailAdapter.setOnMeiziClickListener(this);
        recyclerView.setAdapter(girlDetailAdapter);
    }

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.title_name)
    TextView toolbarTitle;

    private void init() {
        ButterKnife.bind(this);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (toolbarTitle != null) {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbarTitle.setText(R.string.detail);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //捕获返回键按下的事件
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    public void onMeiziClick(View itemView, int position) {
        Intent i = new Intent(GirlDetailActivity.this, DetailActivity.class);
        i.putExtra("position", position);
        startActivity(i);
    }

    @Override
    public void onMeiziLongClick(View itemView, int position) {


    }
}
