package com.yapi.rentku.dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yapi.rentku.MainActivity;
import com.yapi.rentku.R;
import com.yapi.rentku.rest.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Masuk extends AppCompatActivity {

    Button btnMasuk;
    EditText etNamaa, etSandii;

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
        masukResponseCall.enqueue(new Callback<MasukResponse>() {
            @Override
            public void onResponse(Call<MasukResponse> call, Response<MasukResponse> response) {
                if (response.isSuccessful()){
                    MasukRequest masukResponse = response.body().getData();
                    startActivity(new Intent(Masuk.this, MainActivity.class).putExtra("data",masukResponse));
                    finish();

                }else {
                    String pesan = "Daftar gagal, coba lagi";
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
}