package com.qtfreet.beautyleg.data.bean;

/**
 * Created by qtfreet00 on 2016/5/6.
 */
public class imageBean {
    private String url;
    private String albumname;
    private int id;
    private int type;
    private String des;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
