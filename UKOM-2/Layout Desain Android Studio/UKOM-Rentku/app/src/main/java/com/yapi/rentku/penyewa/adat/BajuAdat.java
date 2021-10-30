package com.yapi.rentku.penyewa.adat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;
import com.yapi.rentku.penyewa.Keranjang;
import com.yapi.rentku.penyewa.Registrasi;

public class BajuAdat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baju_adat);
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
}