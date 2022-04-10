package com.yapi.rentku.penyewa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;
import com.yapi.rentku.dm.Daftar;
import com.yapi.rentku.dm.Masuk;
import com.yapi.rentku.penyewa.adat.BajuAdat;

public class Registrasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
    }

    public void btnsetuju(View view) {
        Intent intent = new Intent( Registrasi.this, SelamatRegistrasi.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent( Registrasi.this, BajuAdat.class);
        startActivity(intent);
    }
}