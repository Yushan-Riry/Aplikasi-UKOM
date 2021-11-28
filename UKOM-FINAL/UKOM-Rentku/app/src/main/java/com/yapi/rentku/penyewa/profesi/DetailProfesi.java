package com.yapi.rentku.penyewa.profesi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yapi.rentku.R;
import com.yapi.rentku.adapter.AdapterDetailProfesi;
import com.yapi.rentku.model.DetailProfesiM;
import com.yapi.rentku.model.GetDetailProfesiM;
import com.yapi.rentku.rest.ApiClient;
import com.yapi.rentku.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailProfesi extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static DetailProfesi ma;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profesi);

        //database textview
        TextView tvntokop, tvjmp, tvalmtp;

        Intent mIntent = getIntent();

        tvntokop = (TextView) findViewById(R.id.tvntokop);
        tvjmp    = (TextView) findViewById(R.id.tvjmp);
        tvalmtp  = (TextView) findViewById(R.id.tvalmta);

        tvntokop.setText(mIntent.getStringExtra("Nmtkp"));
        tvjmp.setText(mIntent.getStringExtra("Jmp"));
        tvalmtp.setText(mIntent.getStringExtra("Almtp"));

        //database recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.rcvdetailprofesi);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;

        panggilRetrofit();
    }

    public void bajjusewa(View view) {
        Intent intent = new Intent( DetailProfesi.this, BajuProfesi.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent( DetailProfesi.this, Profesi.class);
        startActivity(intent);
    }

    public void panggilRetrofit() {
        Call<GetDetailProfesiM> detailProfesiMCall = mApiInterface.getDetailProfesi();
        detailProfesiMCall.enqueue(new Callback<GetDetailProfesiM>() {
            @Override
            public void onResponse(Call<GetDetailProfesiM> call, Response<GetDetailProfesiM>
                    response) {
                List<DetailProfesiM> detailProfesiMList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(detailProfesiMList.size()));
                mAdapter = new AdapterDetailProfesi(detailProfesiMList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetDetailProfesiM> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    public void btnnext(View view) {
        Intent intent = new Intent( DetailProfesi.this, BajuProfesi.class);
        startActivity(intent);
    }
}