package com.yapi.rentku.penyewa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;
import com.yapi.rentku.penyewa.profesi.BajuProfesi;

public class FormulirSewa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir_sewa);
    }

    public void btnseewa(View view) {
        Intent intent = new Intent( FormulirSewa.this, Sewaanku.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent( FormulirSewa.this, BajuProfesi.class);
        startActivity(intent);
    }
}