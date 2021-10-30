package com.yapi.rentku.penyewa.adat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.MainActivity;
import com.yapi.rentku.R;
import com.yapi.rentku.dm.Daftar;
import com.yapi.rentku.dm.Masuk;

public class Adat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adat);
    }

    public void tokosewa(View view) {
        Intent intent = new Intent( Adat.this, DetailAdat.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent( Adat.this, MainActivity.class);
        startActivity(intent);
    }
}