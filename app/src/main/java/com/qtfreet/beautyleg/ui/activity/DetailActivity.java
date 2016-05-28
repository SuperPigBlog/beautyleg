package com.qtfreet.beautyleg.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.qtfreet.beautyleg.R;
import com.qtfreet.beautyleg.data.bean.ImageUrlList;
import com.qtfreet.beautyleg.ui.App;
import com.qtfreet.beautyleg.utils.SaveImageTask;
import com.qtfreet.beautyleg.wiget.ActionSheetDialog;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by qtfreet on 2016/3/5.
 */
public class DetailActivity extends AppCompatActivity implements View.OnLongClickListener {

    @Bind(R.id.iv_meizi)
    ImageView image;
    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;

    @Bind(R.id.pb_search_wait)
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_detail);
        App.getInstance().addActivity(DetailActivity.this);

        init();
    }

    int i = 0;
    String url = "";

    private void init() {
        ButterKnife.bind(this);
        i = getIntent().getIntExtra("position", 1);
        url = ImageUrlList.bigurl.get(i);
        Log.e("qtfreet111", url);
        progressBar.setVisibility(View.VISIBLE);
        Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                image.setImageDrawable(resource);
                progressBar.setVisibility(View.GONE);
            }
        });
        image.setOnLongClickListener(this);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //继承了Activity的onTouchEvent方法，直接监听点击事件
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
            y1 = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = event.getX();
            y2 = event.getY();
            if (x1 - x2 > 50) {
                i++;
                if (i > ImageUrlList.url.size()) {
                    return false;
                }
                progressBar.setVisibility(View.VISIBLE);
                Log.e("qtfreet111", ImageUrlList.bigurl.get(i));
                url = ImageUrlList.bigurl.get(i);
                Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        image.setImageDrawable(resource);
                        progressBar.setVisibility(View.GONE);
                    }
                });


            } else if (x2 - x1 > 50) {
                i--;
                if (i < 0) {
                    return false;
                }
                Log.e("qtfreet111", ImageUrlList.bigurl.get(i));
                progressBar.setVisibility(View.VISIBLE);
                url = ImageUrlList.bigurl.get(i);
                Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        image.setImageDrawable(resource);
                        progressBar.setVisibility(View.GONE);
                    }
                });


            }
        }
        return super.onTouchEvent(event);
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
    public boolean onLongClick(View v) {

        new ActionSheetDialog(this).builder().setTitle("提示").addSheetItem("保存", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onClick(int which) {
                try {
                    SaveImageTask saveImageTask = new SaveImageTask(DetailActivity.this, String.valueOf(System.currentTimeMillis()));
                    saveImageTask.execute(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).show();
        return true;
    }
}
