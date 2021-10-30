package com.yapi.rentku.penyewa.profesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;

public class DetailProfesi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profesi);
    }

    public void bajjusewa(View view) {
        Intent intent = new Intent( DetailProfesi.this, BajuProfesi.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent( DetailProfesi.this, Profesi.class);
        startActivity(intent);
    }
}