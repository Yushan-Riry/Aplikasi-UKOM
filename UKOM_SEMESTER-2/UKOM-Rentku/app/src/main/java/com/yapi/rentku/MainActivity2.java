package com.yapi.rentku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yapi.rentku.penyewa.Keranjang;
import com.yapi.rentku.penyewa.Riwayat;
import com.yapi.rentku.penyewa.Saya;
import com.yapi.rentku.penyewa.adat.Adat;
import com.yapi.rentku.persewaan.Disewa;
import com.yapi.rentku.persewaan.Posting;
import com.yapi.rentku.persewaan.PostingBaru;
import com.yapi.rentku.persewaan.Toko;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationtoko);

        //Home
        bottomNavigationView.setSelectedItemId(R.id.homee);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homee:
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
                        startActivity(new Intent(getApplicationContext()
                                , Toko.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
    }

    public void postingbaju(View view) {
        Intent intent = new Intent( MainActivity2.this, PostingBaru.class);
        startActivity(intent);
    }
}