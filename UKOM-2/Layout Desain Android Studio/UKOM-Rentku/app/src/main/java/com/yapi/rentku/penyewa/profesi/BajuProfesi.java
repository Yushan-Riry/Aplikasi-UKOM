package com.yapi.rentku.penyewa.profesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;
import com.yapi.rentku.dm.Daftar;
import com.yapi.rentku.dm.Masuk;
import com.yapi.rentku.penyewa.FormulirSewa;
import com.yapi.rentku.penyewa.Keranjang;
import com.yapi.rentku.penyewa.adat.DetailAdat;

public class BajuProfesi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baju_profesi);
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