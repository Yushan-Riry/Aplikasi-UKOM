package com.yapi.rentku.penyewa.adat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yapi.rentku.R;
import com.yapi.rentku.penyewa.Keranjang;
import com.yapi.rentku.penyewa.Registrasi;
import com.yapi.rentku.rest.ApiInterface;

public class BajuAdat extends AppCompatActivity {

    ImageView iv;
    TextView tvnbadat, tvkondisia, tvhargaa, tvnamatk, tvket;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static BajuAdat ma;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baju_adat);
        Intent mIntent = getIntent();

        // tampil gambar
        iv = findViewById(R.id.ivba);
        // String rr = mIntent.getStringExtra("gambar");

        Glide.with(BajuAdat.this)
                .load(""+mIntent.getStringExtra("Gambar"))
              //  .apply(new RequestOptions().override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL))
                .into(iv);

        tvnbadat    = (TextView) findViewById(R.id.tvnbadat);
        tvkondisia  = (TextView) findViewById(R.id.tvkondisia);
        tvhargaa    = (TextView) findViewById(R.id.tvhargaa);
       // tvalmta     = (TextView) findViewById(R.id.tvalmta);
        tvnamatk    = (TextView) findViewById(R.id.tvntoko);
        tvket       = (TextView) findViewById(R.id.tvket);

        tvnamatk.setText(mIntent.getStringExtra("namatoko"));
        tvnbadat.setText(mIntent.getStringExtra("namabaju"));
        tvkondisia.setText(mIntent.getStringExtra("kondisi"));
        tvhargaa.setText(mIntent.getStringExtra("harga"));
        tvket.setText(mIntent.getStringExtra("ket"));

//        panggilRetrofit();
    }

    public void btnsewa(View view) {
        Intent intent = new Intent( BajuAdat.this, Registrasi.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent( BajuAdat.this, DetailAdat.class);
        startActivity(intent);
    }

    public void keranjang(View view) {
        Intent intent = new Intent( BajuAdat.this, Keranjang.class);
        startActivity(intent);
    }

//    public void panggilRetrofit() {
//        Call<GetDetailAdatM> detailAdatMCall = mApiInterface.getDetailAdat();
//        detailAdatMCall.enqueue(new Callback<GetDetailAdatM>() {
//            @Override
//            public void onResponse(Call<GetDetailAdatM> call, Response<GetDetailAdatM>
//                    response) {
//                List<DetailAdatM> detailAdatMList = response.body().getData();
//                Log.d("Retrofit Get", "Jumlah data: " +
//                        String.valueOf(detailAdatMList.size()));
//                mAdapter = new AdapterDetailAdat(detailAdatMList);
//                mRecyclerView.setAdapter(mAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<GetDetailAdatM> call, Throwable t) {
//                Log.e("Retrofit Get", t.toString());
//            }
//        });
//    }
}