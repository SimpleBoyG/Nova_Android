package com.example.artbuy;

import android.net.Uri;
import android.widget.ImageView;

public class RecyclerViewData {
    private Uri uri_profile;
    private  String name;
    private  String content;

    public RecyclerViewData(Uri uri_profile, String tv_name, String tv_content){
        this.uri_profile = uri_profile;
        this.name = tv_name;
        this.content = tv_content;
    }

    public Uri getIv_profile() {
        return uri_profile;
    }

    public String getTv_name() {
        return name;
    }

    public String getTv_content() {
        return content;
    }
}
