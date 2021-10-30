package com.yapi.rentku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yapi.rentku.dm.Daftar;
import com.yapi.rentku.dm.Masuk;
import com.yapi.rentku.penyewa.Keranjang;
import com.yapi.rentku.penyewa.Riwayat;
import com.yapi.rentku.penyewa.Saya;
import com.yapi.rentku.penyewa.adat.Adat;
import com.yapi.rentku.penyewa.profesi.Profesi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Home
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        return true;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext()
                        , Keranjang.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.history:
                        startActivity(new Intent(getApplicationContext()
                                , Riwayat.class));
                        overridePendingTransition(0, 0);
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

    public void panahadat(View view) {
        Intent intent = new Intent( MainActivity.this, Adat.class);
        startActivity(intent);
    }

    public void panahprofesi(View view) {
        Intent intent = new Intent( MainActivity.this, Profesi.class);
        startActivity(intent);
    }
}