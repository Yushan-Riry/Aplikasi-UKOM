package com.yapi.rentku.penyewa.adat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yapi.rentku.R;
import com.yapi.rentku.adapter.AdapterDetailAdat;
import com.yapi.rentku.model.DetailAdatM;
import com.yapi.rentku.model.GetDetailAdatM;
import com.yapi.rentku.rest.ApiClient;
import com.yapi.rentku.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailAdat extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static DetailAdat ma;
    RecyclerView recyclerView;

    //database textview
    TextView tvntoko, tvjm, tvalmt, tvnamabaju, tvknds, tvharga, tvketerangan, tvnbj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_adat);

        //database textview
        Intent mIntent = getIntent();

        tvntoko = (TextView) findViewById(R.id.tvntokop);
        tvjm    = (TextView) findViewById(R.id.tvjmp);
        tvalmt  = (TextView) findViewById(R.id.tvket);
        tvnamabaju  = (TextView) findViewById(R.id.tvNamaBaju);
        tvknds  = (TextView) findViewById(R.id.tvkondisia);
        tvharga  = (TextView) findViewById(R.id.tvHarga);
        tvketerangan  = (TextView) findViewById(R.id.tvKeterangan);
       // tvnbj  = (TextView) findViewById(R.id.tvnbadat);

        tvntoko.setText(mIntent.getStringExtra("ntoko"));
        //tvnbj.setText(mIntent.getStringExtra("namabaju"));
        tvjm.setText(mIntent.getStringExtra("jam"));
        tvalmt.setText(mIntent.getStringExtra("alamat"));
//        tvnamabaju.setText(mIntent.getStringExtra("Nmbj"));
//        tvknds.setText(mIntent.getStringExtra("Knds"));
//        tvharga.setText(mIntent.getStringExtra("Hrg"));
//        tvketerangan.setText(mIntent.getStringExtra("Deskbj"));

        //database recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.rcvdetailadat);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;

        panggilRetrofit();
    }

    public void bajusewa(View view) {
        Intent intent = new Intent(DetailAdat.this, BajuAdat.class);
        intent.putExtra("gambar", getIntent().getStringExtra("gambar"));
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent(DetailAdat.this, Adat.class);
        startActivity(intent);
    }

    public void panggilRetrofit() {
        Call<GetDetailAdatM> detailAdatMCall = mApiInterface.getDetailAdat();
        detailAdatMCall.enqueue(new Callback<GetDetailAdatM>() {
            @Override
            public void onResponse(Call<GetDetailAdatM> call, Response<GetDetailAdatM>
                    response) {
                List<DetailAdatM> detailAdatMList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data: " +
                        String.valueOf(detailAdatMList.size()));
                mAdapter = new AdapterDetailAdat(detailAdatMList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetDetailAdatM> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}