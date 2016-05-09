package com.qtfreet.beautyleg.data.bean;

import java.util.List;

/**
 * Created by qtfreet00 on 2016/5/7.
 */
public class videoBean {


    /**
     * id : 8894
     * groupid : 1
     * modelid : 46
     * no : 4
     * pubdate : 2016-04-25
     * albumname : [BeautyModel]No.004 美腿Queena网路影音视频写真
     * description :  BeautyModel系列美腿Queena网路影音视频写真
     * filedirectory : /BeautylegVideo/Queena
     * filename : http://a.hiphotos.baidu.com/image/pic/item/14ce36d3d539b6009a038e37ee50352ac75cb765.jpg?
     * thumbpicurl : http://a.hiphotos.baidu.com/image/pic/item/14ce36d3d539b6009a038e37ee50352ac75cb765.jpg?
     * type : 1
     * videoList : [{"id":5079,"albumid":8894,"vd":4,"vdDesc":"1080P 超清","filedirectory":"/BeautylegVideo/Queena/","filename":"No.004Queena_1080p.mp4","fileType":"mp4","videoUrl":"http://app.beautylegcn.com/data/media/lecloud.jsp?fid=160425161316000102280960210002&id=5079","referer":"","portrait":0,"createtime":"Apr 25, 2016","fileSize":0},{"id":5080,"albumid":8894,"vd":7,"vdDesc":"原画","filedirectory":"/BeautylegVideo/Queena/","filename":"No.004Queena_原画.mp4","fileType":"mp4","videoUrl":"http://app.beautylegcn.com/data/media/ppcloud.jsp?id=5080","referer":"","portrait":0,"createtime":"Apr 25, 2016","fileSize":0}]
     * photoListMap : {}
     * photoDefList : []
     * model : {"id":46,"groupid":1,"name":"Queena","namecn":"","description":"","coverimage":"http://a.hiphotos.baidu.com/image/pic/item/2e2eb9389b504fc2fd55ddfce0dde71191ef6dc4.jpg","albumcount":11,"status":0,"flag":0}
     * sourceUrl : http://app.beautylegcn.com/data/albumDetail.jsp?id=8894&hd=1&cs=9889fa165ba44974de3ae308b2986c2d&t=1462599853471&uc=Beautyleg&pn=com.mason.beautyleg&av=39&mac=08:00:27:04:69:94&sessionid=4f252b35000924a089527455ca076c519581913f452118e06c25261412839480fefe7d4120b8e2dd&utoken=0&kd=false&&listall=1
     * fileCount : 2
     * zan : 276
     * click : 61005
     * flag : 0
     * storage : 0
     * thumb : 0
     * vip : 0
     * level : 0
     */

    private int id;
    private int groupid;
    private int modelid;
    private int no;
    private String pubdate;
    private String albumname;
    private String description;
    private String filedirectory;
    private String filename;
    private String thumbpicurl;
    private int type;
    /**
     * id : 46
     * groupid : 1
     * name : Queena
     * namecn :
     * description :
     * coverimage : http://a.hiphotos.baidu.com/image/pic/item/2e2eb9389b504fc2fd55ddfce0dde71191ef6dc4.jpg
     * albumcount : 11
     * status : 0
     * flag : 0
     */

    private ModelBean model;
    private String sourceUrl;
    private int fileCount;
    private int zan;
    private int click;
    private int flag;
    private int storage;
    private int thumb;
    private int vip;
    private int level;
    /**
     * id : 5079
     * albumid : 8894
     * vd : 4
     * vdDesc : 1080P 超清
     * filedirectory : /BeautylegVideo/Queena/
     * filename : No.004Queena_1080p.mp4
     * fileType : mp4
     * videoUrl : http://app.beautylegcn.com/data/media/lecloud.jsp?fid=160425161316000102280960210002&id=5079
     * referer :
     * portrait : 0
     * createtime : Apr 25, 2016
     * fileSize : 0
     */

    private List<VideoListBean> videoList;
    private List<?> photoDefList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getModelid() {
        return modelid;
    }

    public void setModelid(int modelid) {
        this.modelid = modelid;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFiledirectory() {
        return filedirectory;
    }

    public void setFiledirectory(String filedirectory) {
        this.filedirectory = filedirectory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getThumbpicurl() {
        return thumbpicurl;
    }

    public void setThumbpicurl(String thumbpicurl) {
        this.thumbpicurl = thumbpicurl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<VideoListBean> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoListBean> videoList) {
        this.videoList = videoList;
    }

    public List<?> getPhotoDefList() {
        return photoDefList;
    }

    public void setPhotoDefList(List<?> photoDefList) {
        this.photoDefList = photoDefList;
    }

    public static class ModelBean {
        private int id;
        private int groupid;
        private String name;
        private String namecn;
        private String description;
        private String coverimage;
        private int albumcount;
        private int status;
        private int flag;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGroupid() {
            return groupid;
        }

        public void setGroupid(int groupid) {
            this.groupid = groupid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNamecn() {
            return namecn;
        }

        public void setNamecn(String namecn) {
            this.namecn = namecn;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCoverimage() {
            return coverimage;
        }

        public void setCoverimage(String coverimage) {
            this.coverimage = coverimage;
        }

        public int getAlbumcount() {
            return albumcount;
        }

        public void setAlbumcount(int albumcount) {
            this.albumcount = albumcount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }
    }

    public static class VideoListBean {
        private int id;
        private int albumid;
        private int vd;
        private String vdDesc;
        private String filedirectory;
        private String filename;
        private String fileType;
        private String videoUrl;
        private String referer;
        private int portrait;
        private String createtime;
        private int fileSize;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAlbumid() {
            return albumid;
        }

        public void setAlbumid(int albumid) {
            this.albumid = albumid;
        }

        public int getVd() {
            return vd;
        }

        public void setVd(int vd) {
            this.vd = vd;
        }

        public String getVdDesc() {
            return vdDesc;
        }

        public void setVdDesc(String vdDesc) {
            this.vdDesc = vdDesc;
        }

        public String getFiledirectory() {
            return filedirectory;
        }

        public void setFiledirectory(String filedirectory) {
            this.filedirectory = filedirectory;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public String getReferer() {
            return referer;
        }

        public void setReferer(String referer) {
            this.referer = referer;
        }

        public int getPortrait() {
            return portrait;
        }

        public void setPortrait(int portrait) {
            this.portrait = portrait;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getFileSize() {
            return fileSize;
        }

        public void setFileSize(int fileSize) {
            this.fileSize = fileSize;
        }
    }
}
