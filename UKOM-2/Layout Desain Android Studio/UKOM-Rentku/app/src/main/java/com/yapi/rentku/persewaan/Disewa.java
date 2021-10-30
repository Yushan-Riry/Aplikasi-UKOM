package com.yapi.rentku.persewaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yapi.rentku.MainActivity2;
import com.yapi.rentku.R;
import com.yapi.rentku.penyewa.Keranjang;
import com.yapi.rentku.penyewa.Riwayat;
import com.yapi.rentku.penyewa.Saya;

public class Disewa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disewa);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationtoko);

        //Rent
        bottomNavigationView.setSelectedItemId(R.id.rent);

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
}