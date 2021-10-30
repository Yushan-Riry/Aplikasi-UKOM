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

public class Posting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationtoko);

        //Post
        bottomNavigationView.setSelectedItemId(R.id.post);

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

    public void postigan(View view) {
        Intent intent = new Intent( Posting.this, HasilPosting.class);
        startActivity(intent);
    }
}