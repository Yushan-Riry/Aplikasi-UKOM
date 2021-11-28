package com.yapi.rentku.penyewa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.MainActivity;
import com.yapi.rentku.R;
import com.yapi.rentku.dm.Masuk;
import com.yapi.rentku.penyewa.adat.Adat;
import com.yapi.rentku.persewaan.Toko;

public class Sayawpartner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayawpartner);
    }

    public void keluar(View view) {
        Intent intent = new Intent( Sayawpartner.this, Masuk.class);
        startActivity(intent);
    }

    public void kesewaan(View view) {
        Intent intent = new Intent( Sayawpartner.this, Sewaanku.class);
        startActivity(intent);
    }

    public void pindah(View view) {
        Intent intent = new Intent( Sayawpartner.this, Toko.class);
        startActivity(intent);
    }

    public void edit(View view) {
        Intent intent = new Intent( Sayawpartner.this, EditSaya.class);
        startActivity(intent);
    }
}