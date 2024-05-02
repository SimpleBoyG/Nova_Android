package com.example.artbuy;

import android.net.Uri;
import android.widget.ImageView;

public class RecyclerViewData {
    private Uri uri_profile;
    private  String tv_name;
    private  String tv_content;

    public RecyclerViewData(Uri uri_profile, String tv_name, String tv_content){
        this.uri_profile = uri_profile;
        this.tv_name = tv_name;
        this.tv_content = tv_content;
    }

    public Uri getIv_profile() {
        return uri_profile;
    }

    public void setIv_profile(Uri iv_profile) {
        this.uri_profile = uri_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }
}
