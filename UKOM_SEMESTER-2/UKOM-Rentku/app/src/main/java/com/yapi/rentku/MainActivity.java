package com.yapi.rentku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.yapi.rentku.dm.MasukRequest;
import com.yapi.rentku.dm.MasukResponse;
import com.yapi.rentku.penyewa.Keranjang;
import com.yapi.rentku.penyewa.Riwayat;
import com.yapi.rentku.penyewa.Saya;
import com.yapi.rentku.penyewa.adat.Adat;
import com.yapi.rentku.penyewa.profesi.Profesi;
import com.yapi.rentku.rest.ApiClient;
import com.yapi.rentku.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //login
    MasukRequest masukResponse;
    TextView tvnnamaact;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //login
        tvnnamaact = findViewById(R.id.tvnnamaact);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("masuk", "");

        //login
        Intent intent = getIntent();
        if (json != ""){
            masukResponse = gson.fromJson(json, MasukRequest.class);
            tvnnamaact.setText("Halo, "+masukResponse.getNama()+" !");
        }

        // login yang lama
//        if (intent.getExtras() != null){
//            masukResponse = (MasukRequest) intent.getSerializableExtra("data");
//            tvnnamaact.setText("Halo, "+masukResponse.getNama());
//            Log.e("TAG", "====>"+masukResponse.getNama());
//        }

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

        //pisah id
        Integer idKategori = 125;
        Intent intent = new Intent(view.getContext(), Adat.class);
        intent.putExtra("idKategori", idKategori);

        //pindah halaman
//        Intent intent = new Intent( MainActivity.this, Adat.class);
        startActivity(intent);
    }

    public void panahprofesi(View view) {

        //pisah id
        Integer idKategori = 126;
        Intent intent = new Intent(view.getContext(), Adat.class);
        intent.putExtra("idKategori", idKategori);

        //pindah halaman
//        Intent intent = new Intent( MainActivity.this, Profesi.class);
        startActivity(intent);
    }

}