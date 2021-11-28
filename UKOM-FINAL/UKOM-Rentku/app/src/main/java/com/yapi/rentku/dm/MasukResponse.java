package com.yapi.rentku.dm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MasukResponse implements Serializable {

    @SerializedName("pesan")
    @Expose
    private String pesan;
    @SerializedName("data")
    @Expose
    private MasukRequest data;

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public MasukRequest getData() {
        return data;
    }

    public void setData(MasukRequest data) {
        this.data = data;
    }
}
