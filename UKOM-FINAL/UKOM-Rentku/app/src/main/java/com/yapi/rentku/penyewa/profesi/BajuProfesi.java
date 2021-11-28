package com.yapi.rentku.penyewa.profesi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yapi.rentku.R;
import com.yapi.rentku.dm.Daftar;
import com.yapi.rentku.dm.Masuk;
import com.yapi.rentku.penyewa.FormulirSewa;
import com.yapi.rentku.penyewa.Keranjang;
import com.yapi.rentku.penyewa.adat.BajuAdat;
import com.yapi.rentku.penyewa.adat.DetailAdat;
import com.yapi.rentku.rest.ApiInterface;

public class BajuProfesi extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static BajuProfesi ma;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baju_profesi);

        //database textview
        TextView tvnbadat, tvkondisia, tvhargaa, tvalmta;

        Intent mIntent = getIntent();

        tvnbadat = (TextView) findViewById(R.id.tvnbadat);
        tvkondisia    = (TextView) findViewById(R.id.tvkondisia);
        tvhargaa  = (TextView) findViewById(R.id.tvhargaa);
        tvalmta  = (TextView) findViewById(R.id.tvalmta);

        tvnbadat.setText(mIntent.getStringExtra("Nmbjp"));
        tvkondisia.setText(mIntent.getStringExtra("Kndsp"));
        tvhargaa.setText(mIntent.getStringExtra("Hrgp"));
        tvalmta.setText(mIntent.getStringExtra("Deskbjp"));
    }

    public void btnsewaa(View view) {
        Intent intent = new Intent( BajuProfesi.this, FormulirSewa.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent( BajuProfesi.this, DetailProfesi.class);
        startActivity(intent);
    }

    public void keranjang(View view) {
        Intent intent = new Intent( BajuProfesi.this, Keranjang.class);
        startActivity(intent);
    }
}