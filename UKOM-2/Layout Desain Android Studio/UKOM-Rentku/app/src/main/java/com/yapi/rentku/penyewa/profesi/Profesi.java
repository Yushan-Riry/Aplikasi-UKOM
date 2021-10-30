package com.yapi.rentku.penyewa.profesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.MainActivity;
import com.yapi.rentku.R;
import com.yapi.rentku.penyewa.Registrasi;
import com.yapi.rentku.penyewa.adat.BajuAdat;

public class Profesi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesi);
    }

    public void tokkosewa(View view) {
        Intent intent = new Intent( Profesi.this, DetailProfesi.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent( Profesi.this, MainActivity.class);
        startActivity(intent);
    }
}