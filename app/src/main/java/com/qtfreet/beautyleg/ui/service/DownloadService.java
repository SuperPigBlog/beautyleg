package com.qtfreet.beautyleg.ui.service;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.qtfreet.beautyleg.R;
import com.qtfreet.beautyleg.data.bean.ImageUrlList;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;
import java.util.List;

/**
 * Created by qtfreet00 on 2016/5/10.
 */
public class DownloadService extends Service {
    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder mBuilder;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(this);
        if (intent.getIntExtra("type", 0) == 0) {
            downloadImages(ImageUrlList.bigurl, intent.getStringExtra("name"));
        } else if (intent.getIntExtra("type", 0) == 1) {
            downloadVideo(intent.getStringExtra("url"), intent.getStringExtra("name"));
            mBuilder.setContentTitle(intent.getStringExtra("name")).setSmallIcon(getApplicationInfo().icon);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private void downloadImages(List<String> urls, String name) {
        if (urls == null) {
            Toast.makeText(this, "未获取到下载链接", Toast.LENGTH_SHORT).show();
            return;

        }
        Toast.makeText(this, "正在下载中", Toast.LENGTH_SHORT).show();
        int t = urls.size();
        for (int i = 0; i < t; i++) {
            if (i == t - 1) {
                Toast.makeText(DownloadService.this, "下载完成", Toast.LENGTH_SHORT).show();
            }
            OkHttpUtils.get().url(urls.get(i)).build().execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath() + "/BeautyLegDown/" + name, "00" + i + ".jpg") {

                @Override
                public void inProgress(float progress, long total) {

                }

                @Override
                public void onError(okhttp3.Call call, Exception e) {

                }

                @Override
                public void onResponse(File response) {

                }
            });
        }


    }

    private void downloadVideo(String url, String name) {
        if (url.isEmpty()) {
            Toast.makeText(this, "未获取到下载链接", Toast.LENGTH_SHORT).show();
            return;

        }
        FileDownloader.getImpl().create(url)
                .setPath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/BeautyLegDown/" + name + "/" + name + ".mp4")
                .setListener(new FileDownloadListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                    }

                    @Override
                    protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
                        Toast.makeText(DownloadService.this, "正在下载中", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                        updateProgress(soFarBytes * 1000 / totalBytes);

                    }

                    @Override
                    protected void blockComplete(BaseDownloadTask task) {
                    }

                    @Override
                    protected void retry(final BaseDownloadTask task, final Throwable ex, final int retryingTimes, final int soFarBytes) {
                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        Toast.makeText(DownloadService.this, "下载完成", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {
                    }
                }).start();

    }


    private void updateProgress(int progress) {
        mBuilder.setContentText(this.getString(R.string.download_progress, progress)).setProgress(100, progress, false);
        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(), PendingIntent.FLAG_CANCEL_CURRENT);
        mBuilder.setContentIntent(pendingintent);
        mNotifyManager.notify(0, mBuilder.build());
    }

}
