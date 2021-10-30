package com.yapi.rentku.penyewa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;

public class EditSaya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_saya);
    }

    public void btnedit(View view) {
        Intent intent = new Intent( EditSaya.this, Saya.class);
        startActivity(intent);
    }

    public void kembali(View view) {
        Intent intent = new Intent( EditSaya.this, Saya.class);
        startActivity(intent);
    }
}