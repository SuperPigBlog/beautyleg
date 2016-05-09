package com.qtfreet.beautyleg.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.support.v7.app.AlertDialog;

import com.qtfreet.beautyleg.ui.App;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;

/**
 * Created by qtfreet00 on 2016/3/4.
 */
public class Utils {
    public static boolean isMobilePhone(String phone) {//
        Pattern pattern = Pattern
                .compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[6-8])|(18[0-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static void showDialog(Context context, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage(msg);
        builder.setPositiveButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                App.getInstance().exit();
            }
        });
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    public static boolean isSdCardAviable() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    public static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }

    public static OkHttpClient getOkHttpClient(){
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        return client;
    }
    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

}
