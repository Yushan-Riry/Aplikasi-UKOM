package com.yapi.rentku.persewaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yapi.rentku.MainActivity2;
import com.yapi.rentku.R;
import com.yapi.rentku.dm.Masuk;
import com.yapi.rentku.penyewa.EditSaya;
import com.yapi.rentku.penyewa.Saya;
import com.yapi.rentku.penyewa.Sayawpartner;

public class Toko extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toko);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationtoko);

        //Store
        bottomNavigationView.setSelectedItemId(R.id.store);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homee:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity2.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.post:
                        startActivity(new Intent(getApplicationContext()
                                , Posting.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.rent:
                        startActivity(new Intent(getApplicationContext()
                                , Disewa.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.store:
                        return true;

                }
                return false;
            }
        });
    }

    public void edittoko(View view) {
        Intent intent = new Intent( Toko.this, EditToko.class);
        startActivity(intent);
    }

    public void keluar(View view) {
        Intent intent = new Intent( Toko.this, Masuk.class);
        startActivity(intent);
    }

    public void ganti(View view) {
        Intent intent = new Intent( Toko.this, Sayawpartner.class);
        startActivity(intent);
    }
}