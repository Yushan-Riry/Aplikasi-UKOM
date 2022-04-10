package com.yapi.rentku.rest;

import com.yapi.rentku.dm.DaftarRequest;
import com.yapi.rentku.dm.DaftarResponse;
import com.yapi.rentku.dm.MasukRequest;
import com.yapi.rentku.dm.MasukResponse;
import com.yapi.rentku.model.GetLoginEmail;
import com.yapi.rentku.model.GetNewPassword;
import com.yapi.rentku.model.LoginEmail;
import com.yapi.rentku.model.NewPPassword;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @POST("/api/login")
    Call<MasukResponse> masukUser(@Body MasukRequest masukRequest);

    @POST("/api/register")
    Call<DaftarResponse> daftarUser(@Body DaftarRequest daftarRequest);

    @POST("/api/loginpass")
    Call<GetLoginEmail> loginEmail(@Body LoginEmail loginEmail);

    @PUT("/api/user/{id}")
    Call<GetNewPassword> NewPassword(@Path("id") Integer id,
                                     @Body NewPPassword newPPassword);

}
