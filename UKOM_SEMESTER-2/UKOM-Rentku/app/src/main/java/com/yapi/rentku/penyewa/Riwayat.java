package com.yapi.rentku.penyewa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yapi.rentku.MainActivity;
import com.yapi.rentku.R;

public class Riwayat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //History
        bottomNavigationView.setSelectedItemId(R.id.history);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext()
                                , Keranjang.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.history:
                        return true;

                    case R.id.me:
                        startActivity(new Intent(getApplicationContext()
                                , Saya.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
    }
}