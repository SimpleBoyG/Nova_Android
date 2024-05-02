package com.example.artbuy;

import android.net.Uri;

public class PetRegiData {
    private Uri uri_profile;
    private String tv_name;
    private String tv_age;

    public PetRegiData(Uri uri_profile, String tv_name, String tv_age){
        this.uri_profile = uri_profile;
        this.tv_name = tv_name;
        this.tv_age = tv_age;
    }

    public Uri getUri_profile() {
        return uri_profile;
    }

    public void setUri_profile(Uri uri_profile) {
        this.uri_profile = uri_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_age() {
        return tv_age;
    }

    public void setTv_age(String tv_age) {
        this.tv_age = tv_age;
    }
}
