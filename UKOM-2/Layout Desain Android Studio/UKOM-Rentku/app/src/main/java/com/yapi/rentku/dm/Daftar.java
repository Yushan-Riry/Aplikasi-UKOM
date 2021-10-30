package com.yapi.rentku.dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;

public class Daftar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
    }

    public void daftar(View view) {
        Intent intent = new Intent( Daftar.this, Masuk.class);
        startActivity(intent);
    }

    public void masuk(View view) {
        Intent intent = new Intent( Daftar.this, Masuk.class);
        startActivity(intent);
    }
}