package com.yapi.rentku.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yapi.rentku.penyewa.adat.DetailAdat;

import java.util.List;

public class GetDetailAdatM {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<DetailAdatM> data = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<DetailAdatM> getData() {
        return data;
    }

    public void setData(List<DetailAdatM> data) {
        this.data = data;
    }

}
