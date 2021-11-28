package com.yapi.rentku.penyewa.adat;

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
import com.yapi.rentku.dm.Daftar;
import com.yapi.rentku.dm.Masuk;
import com.yapi.rentku.model.AdatM;
import com.yapi.rentku.model.GetAdatM;
import com.yapi.rentku.rest.ApiClient;
import com.yapi.rentku.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Adat extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static Adat ma;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adat);

        mRecyclerView = (RecyclerView) findViewById(R.id.rcvadat);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;

        panggilRetrofit();
        run();

    }

    public void tokosewa(View view) {
        Intent intent = new Intent( Adat.this, DetailAdat.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent(Adat.this, MainActivity.class);
        startActivity(intent);
    }

    public void panggilRetrofit() {
        Call<GetAdatM> adatMCall = mApiInterface.getAdat();
        adatMCall.enqueue(new Callback<GetAdatM>() {
            @Override
            public void onResponse(Call<GetAdatM> call, Response<GetAdatM>
                    response) {
                List<AdatM> adatMList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data: " +
                        String.valueOf(adatMList.size()));
                mAdapter = new AdapterAdat(adatMList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetAdatM> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });

    }

    public void run() {
        ma = this;
        Intent mIntent = getIntent();
        Intent intent  = new Intent();
        intent.putExtra("idKategori", mIntent.getIntExtra("idKategori", 0));
    }
}