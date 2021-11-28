package com.yapi.rentku.penyewa.profesi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.yapi.rentku.MainActivity;
import com.yapi.rentku.R;
import com.yapi.rentku.adapter.AdapterAdat;
import com.yapi.rentku.adapter.AdapterProfesi;
import com.yapi.rentku.model.AdatM;
import com.yapi.rentku.model.GetAdatM;
import com.yapi.rentku.model.GetProfesiM;
import com.yapi.rentku.model.ProfesiM;
import com.yapi.rentku.penyewa.Registrasi;
import com.yapi.rentku.penyewa.adat.Adat;
import com.yapi.rentku.penyewa.adat.BajuAdat;
import com.yapi.rentku.rest.ApiClient;
import com.yapi.rentku.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profesi extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static Profesi ma;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesi);

        mRecyclerView = (RecyclerView) findViewById(R.id.rcvprofesi);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;

        panggilRetrofit();
    }

    public void tokkosewa(View view) {
        Intent intent = new Intent( Profesi.this, DetailProfesi.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent( Profesi.this, MainActivity.class);
        startActivity(intent);
    }

    public void panggilRetrofit() {
        Call<GetProfesiM> profesiMCall = mApiInterface.getProfesi();
        profesiMCall.enqueue(new Callback<GetProfesiM>() {
            @Override
            public void onResponse(Call<GetProfesiM> call, Response<GetProfesiM>
                    response) {
                List<ProfesiM> profesiMList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(profesiMList.size()));
                mAdapter = new AdapterProfesi(profesiMList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetProfesiM> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });

    }
}