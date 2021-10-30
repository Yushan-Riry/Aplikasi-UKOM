package com.yapi.rentku.penyewa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.MainActivity;
import com.yapi.rentku.R;
import com.yapi.rentku.penyewa.adat.Adat;

public class Sewaanku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewaanku);
    }

    public void sewaanku(View view) {
        Intent intent = new Intent( Sewaanku.this, Sayaktp.class);
        startActivity(intent);
    }

    public void kembali(View view) {
        Intent intent = new Intent( Sewaanku.this, Sayaktp.class);
        startActivity(intent);
    }
}