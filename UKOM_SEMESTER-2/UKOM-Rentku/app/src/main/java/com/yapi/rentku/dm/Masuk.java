package com.yapi.rentku.dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yapi.rentku.MainActivity;
import com.yapi.rentku.R;
import com.yapi.rentku.partnership.FormulirBaru;
import com.yapi.rentku.penyewa.Saya;
import com.yapi.rentku.rest.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Masuk extends AppCompatActivity {

    Button btnMasuk;
    EditText etNamaa, etSandii;
    SharedPreferences sharedPreferences;
    MasukRequest mr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        btnMasuk = findViewById(R.id.btnMasuk);
        etNamaa  = findViewById(R.id.etNamaa);
        etSandii = findViewById(R.id.etSandii);
    }

    public void btnmasuk(View view) {

        //logindaftar
        if (TextUtils.isEmpty(etNamaa.getText().toString()) || TextUtils.isEmpty(etSandii.getText().toString())){
            String pesan = "Isi semua data terlebih dahulu !";
            Toast.makeText(Masuk.this,pesan,Toast.LENGTH_LONG).show();

        }else{
            MasukRequest masukRequest = new MasukRequest();
            masukRequest.setNama(etNamaa.getText().toString());
            masukRequest.setSandi(etSandii.getText().toString());

            masukUser1(masukRequest);
        }

        //pindah halaman
//        Intent intent = new Intent( Masuk.this, MainActivity.class);
//        startActivity(intent);
    }

    public void daftar(View view) {
        Intent intent = new Intent( Masuk.this, Daftar.class);
        startActivity(intent);
    }

    public void masukUser1(MasukRequest masukRequest){
        Call<MasukResponse> masukResponseCall = ApiClient.getService().masukUser(masukRequest);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        masukResponseCall.enqueue(new Callback<MasukResponse>() {
            @Override
            public void onResponse(Call<MasukResponse> call, Response<MasukResponse> response) {
//                if (response.isSuccessful()){
//                    MasukRequest masukResponse = response.body().getData();
//                    startActivity(new Intent(Masuk.this, MainActivity.class).putExtra("data",masukResponse));
//                    finish();

                    if (response.isSuccessful()){
                        MasukResponse masukResponse = response.body();
                        mr = masukResponse.getData();
                        Gson gson = new Gson();
                        String json = gson.toJson(mr);
                        editor.putString("masuk", json);
                        editor.commit();
                        startActivity(new Intent(Masuk.this, MainActivity.class).putExtra("data",masukResponse));
                        finish();

                }else {
                    String pesan = "Masukkan Nama atau Sandi yang Benar ! ";
                    Toast.makeText(Masuk.this,pesan,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MasukResponse> call, Throwable t) {

                String pesan = t.getLocalizedMessage();
                Toast.makeText(Masuk.this,pesan,Toast.LENGTH_LONG).show();

            }
        });
    }

    public void lupapw(View view) {
        Intent intent = new Intent( Masuk.this, NamaLupaMasuk.class);
        startActivity(intent);
    }
}