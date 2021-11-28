package com.yapi.rentku.rest;

import com.yapi.rentku.dm.DaftarRequest;
import com.yapi.rentku.dm.DaftarResponse;
import com.yapi.rentku.dm.MasukRequest;
import com.yapi.rentku.dm.MasukResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/api/login")
    Call<MasukResponse> masukUser(@Body MasukRequest masukRequest);

    @POST("/api/register")
    Call<DaftarResponse> daftarUser(@Body DaftarRequest daftarRequest);

}
