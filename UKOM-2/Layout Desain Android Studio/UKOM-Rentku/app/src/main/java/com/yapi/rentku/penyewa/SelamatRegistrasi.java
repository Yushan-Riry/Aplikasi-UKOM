package com.yapi.rentku.penyewa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;

public class SelamatRegistrasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selamat_registrasi);
    }

    public void btnselesairgs(View view) {
        Intent intent = new Intent( SelamatRegistrasi.this, Sayaktp.class);
        startActivity(intent);
    }
}