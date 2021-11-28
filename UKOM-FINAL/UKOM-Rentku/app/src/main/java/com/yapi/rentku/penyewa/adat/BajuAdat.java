package com.yapi.rentku.penyewa.adat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yapi.rentku.R;
import com.yapi.rentku.penyewa.Keranjang;
import com.yapi.rentku.penyewa.Registrasi;
import com.yapi.rentku.rest.ApiInterface;

public class BajuAdat extends AppCompatActivity {

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

        //database textview
        TextView tvnbadat, tvkondisia, tvhargaa, tvalmta;

        Intent mIntent = getIntent();

        tvnbadat = (TextView) findViewById(R.id.tvnbadat);
        tvkondisia    = (TextView) findViewById(R.id.tvkondisia);
        tvhargaa  = (TextView) findViewById(R.id.tvhargaa);
        tvalmta  = (TextView) findViewById(R.id.tvalmta);

        tvnbadat.setText(mIntent.getStringExtra("Nmbj"));
        tvkondisia.setText(mIntent.getStringExtra("Knds"));
        tvhargaa.setText(mIntent.getStringExtra("Hrg"));
        tvalmta.setText(mIntent.getStringExtra("Deskbj"));

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