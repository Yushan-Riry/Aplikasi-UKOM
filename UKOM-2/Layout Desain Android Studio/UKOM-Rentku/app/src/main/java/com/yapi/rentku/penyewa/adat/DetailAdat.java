package com.yapi.rentku.penyewa.adat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;

public class DetailAdat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_adat);
    }

    public void bajusewa(View view) {
        Intent intent = new Intent( DetailAdat.this, BajuAdat.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent( DetailAdat.this, Adat.class);
        startActivity(intent);
    }
}