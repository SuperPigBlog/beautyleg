package com.qtfreet.beautyleg.data.net;

import com.qtfreet.beautyleg.data.bean.DetailImageBean;
import com.qtfreet.beautyleg.data.bean.blBean;
import com.qtfreet.beautyleg.data.bean.videoBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by qtfreet on 2016/3/30.
 */
public interface ApiService {

    @GET("data/cover.jsp")
    Call<List<blBean>> TU(@Query("gid") String git, @Query("type") String type, @Query("cs") String cs, @Query("ps") String ps, @Query("utoken") String utoken,@Query("t") String t, @Query("p") int page,@Query("cs") String cs2);
//    http://app.beautylegcn.com/data/detail.jsp?ps=1000&t=1462513161268&hd=4&cs=99006c75440c7f66ec39c69a122bb346&id=8777&sessionid=7ee945c8e3224e6ec8ca0f2bfecf44bd9581913f452118e06c252614128394809e52b3187a38f561
    @GET("data/detail.jsp")
    Call<List<DetailImageBean>> Detail(@Query("ps") int ps, @Query("t") long t, @Query("hd") int hd, @Query("cs") String cs, @Query("id") int id,@Query("utoken") String token);

   // http://app.beautylegcn.com/data/albumDetail.jsp?id=8894&hd=1&cs=9889fa165ba44974de3ae308b2986c2d&t=1462599853471&uc=Beautyleg&pn=com.mason.beautyleg&av=39&mac=08:00:27:04:69:94&sessionid=4f252b35000924a089527455ca076c519581913f452118e06c25261412839480fefe7d4120b8e2dd&utoken=0&kd=false&

    @GET("data/albumDetail.jsp")
    Call<videoBean> Video(@Query("id") int id,@Query("hd") String hd,@Query("cs") String cs,@Query("t") long time,@Query("uc") String uc,@Query("pn") String pn,@Query("av") String av,@Query("mac") String mac,@Query("sessionid") String sessionid,@Query("utoken") String utoken,@Query("kd") boolean kd);
}
