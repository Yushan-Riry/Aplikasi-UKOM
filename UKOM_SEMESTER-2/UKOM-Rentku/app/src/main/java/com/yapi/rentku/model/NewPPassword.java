package com.yapi.rentku.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewPPassword {
    @SerializedName("sandi")
    @Expose
    private String sandi;

    public String getSandi() {
        return sandi;
    }

    public void setSandi(String sandi) {
        this.sandi = sandi;
    }
}
