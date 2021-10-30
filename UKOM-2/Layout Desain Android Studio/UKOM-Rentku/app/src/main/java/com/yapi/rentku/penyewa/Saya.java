package com.yapi.rentku.penyewa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yapi.rentku.MainActivity;
import com.yapi.rentku.MainActivity2;
import com.yapi.rentku.R;
import com.yapi.rentku.dm.Daftar;
import com.yapi.rentku.dm.Masuk;
import com.yapi.rentku.partnership.FormulirBaru;

public class Saya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saya);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Me
        bottomNavigationView.setSelectedItemId(R.id.me);

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
                        startActivity(new Intent(getApplicationContext()
                                , Riwayat.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.me:
                        return true;

                }
                return false;
            }
        });
    }

    public void kliksaya(View view) {
        Intent intent = new Intent( Saya.this, FormulirBaru.class);
        startActivity(intent);
    }

    public void editsaya(View view) {
        Intent intent = new Intent( Saya.this, EditSaya.class);
        startActivity(intent);
    }

    public void keluar(View view) {
        Intent intent = new Intent( Saya.this, Masuk.class);
        startActivity(intent);
    }
}