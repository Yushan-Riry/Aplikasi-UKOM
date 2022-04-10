package com.yapi.rentku.rest;

import com.yapi.rentku.model.GetAdatM;
import com.yapi.rentku.model.GetDetailAdatM;
import com.yapi.rentku.model.GetDetailProfesiM;
import com.yapi.rentku.model.GetProfesiM;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/api/menu")
    Call<GetAdatM> getAdat();

    @GET("/api/menu")
    Call<GetDetailAdatM> getDetailAdat();

    @GET("/api/menu")
    Call<GetProfesiM> getProfesi();

    @GET("/api/menu")
    Call<GetDetailProfesiM> getDetailProfesi();

}
