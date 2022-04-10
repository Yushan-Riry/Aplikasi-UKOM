package com.yapi.rentku.dm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DaftarResponse {

    @SerializedName("pesan")
    @Expose
    private String pesan;
    @SerializedName("data")
    @Expose
    private DaftarRequest data;

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public DaftarRequest getData() {
        return data;
    }

    public void setData(DaftarRequest data) {
        this.data = data;
    }
}
