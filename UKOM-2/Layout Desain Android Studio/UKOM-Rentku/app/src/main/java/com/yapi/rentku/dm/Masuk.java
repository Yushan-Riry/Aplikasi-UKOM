package com.yapi.rentku.dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.MainActivity;
import com.yapi.rentku.R;

public class Masuk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);
    }

    public void btnmasuk(View view) {
        Intent intent = new Intent( Masuk.this, MainActivity.class);
        startActivity(intent);
    }

    public void daftar(View view) {
        Intent intent = new Intent( Masuk.this, Daftar.class);
        startActivity(intent);
    }
}