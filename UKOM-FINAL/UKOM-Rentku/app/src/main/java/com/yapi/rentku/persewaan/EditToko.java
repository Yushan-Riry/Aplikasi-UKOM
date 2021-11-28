package com.yapi.rentku.persewaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;
import com.yapi.rentku.penyewa.EditSaya;
import com.yapi.rentku.penyewa.Saya;

public class EditToko extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_toko);
    }

    public void btneditt(View view) {
        Intent intent = new Intent( EditToko.this, Toko.class);
        startActivity(intent);
    }

    public void kemblai(View view) {
        Intent intent = new Intent( EditToko.this, Toko.class);
        startActivity(intent);
    }
}