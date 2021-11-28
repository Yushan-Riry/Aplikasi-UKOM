package com.yapi.rentku.partnership;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.MainActivity;
import com.yapi.rentku.MainActivity2;
import com.yapi.rentku.R;
import com.yapi.rentku.penyewa.FormulirSewa;
import com.yapi.rentku.penyewa.Saya;
import com.yapi.rentku.penyewa.SelamatRegistrasi;

public class FormulirBaru extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir_baru);
    }

    public void btngabung(View view) {
        Intent intent = new Intent( FormulirBaru.this, MainActivity2.class);
        startActivity(intent);
    }

    public void btnkembali(View view) {
        Intent intent = new Intent( FormulirBaru.this, Saya.class);
        startActivity(intent);
    }
}