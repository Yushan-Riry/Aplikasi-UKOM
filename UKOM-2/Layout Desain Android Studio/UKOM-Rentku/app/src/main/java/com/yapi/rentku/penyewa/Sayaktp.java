package com.yapi.rentku.penyewa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;
import com.yapi.rentku.dm.Masuk;
import com.yapi.rentku.partnership.FormulirBaru;

public class Sayaktp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayaktp);
    }

    public void prtnrshp(View view) {
        Intent intent = new Intent( Sayaktp.this, FormulirBaru.class);
        startActivity(intent);
    }

    public void kesewaan(View view) {
        Intent intent = new Intent( Sayaktp.this, Sewaanku.class);
        startActivity(intent);
    }

    public void keluar(View view) {
        Intent intent = new Intent( Sayaktp.this, Masuk.class);
        startActivity(intent);
    }
}