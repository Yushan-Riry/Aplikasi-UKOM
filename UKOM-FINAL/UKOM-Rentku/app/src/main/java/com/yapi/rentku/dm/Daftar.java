package com.yapi.rentku.dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yapi.rentku.R;
import com.yapi.rentku.rest.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Daftar extends AppCompatActivity {

    Button btnDaftar;
    EditText etNama, etAlamat, etTelp, etSandi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        btnDaftar = findViewById(R.id.btndaftar);
        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etTelp = findViewById(R.id.etTelp);
        etSandi = findViewById(R.id.etSandi);


//        btnDaftar = findViewById(R.id.btndaftar);
//        btnDaftar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (telp.isEmpty() || telp.length()<13 && telp.length()<12){
//                        showError(etTelp,"Nomer Teleponmu Tidak Valid !");
//                    }else if (sandi.isEmpty() || sandi.length()<6) {
//                        showError(etSandi, "Kata Sandi Harus Lebih dari 6 Kalimat !");
//                    }else {
//                        DaftarRequest daftarRequest = new DaftarRequest();
//                                daftarRequest.setNama(etNama.getText().toString());
//                                daftarRequest.setAlamat(etAlamat.getText().toString());
//                                daftarRequest.setTelp(etTelp.getText().toString());
//                                daftarRequest.setSandi(etSandi.getText().toString());
//                                daftarUser(daftarRequest);
//                    }
//
//            }
//        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etNama.getText().toString()) || TextUtils.isEmpty(etAlamat.getText().toString())
                        || TextUtils.isEmpty(etTelp.getText().toString()) || TextUtils.isEmpty(etSandi.getText().toString())) {

                    String pesan = "Isi semua data terlebih dahulu !";
                    Toast.makeText(Daftar.this, pesan, Toast.LENGTH_LONG).show();
////                } else if (telp.isEmpty() || telp.length() < 12) {
////                    showError(etTelp, "Nomer Teleponmu Tidak Valid !");
//
//                } else if (sandi.isEmpty() || sandi.length() > 6) {
//                    showError(etSandi, "Kata Sandi Harus Lebih dari 6 Kalimat !");

                } else {
                    DaftarRequest daftarRequest = new DaftarRequest();
                    daftarRequest.setNama(etNama.getText().toString());
                    daftarRequest.setAlamat(etAlamat.getText().toString());
                    daftarRequest.setTelp(etTelp.getText().toString());
                    daftarRequest.setSandi(etSandi.getText().toString());
                    daftarUser(daftarRequest);
                }
            }
        });
    }

//    public void chekCredentials() {
//        String nama = etNama.getText().toString();
//        String alamat = etAlamat.getText().toString();
//        String telp = etTelp.getText().toString();
//        String sandi = etSandi.getText().toString();
//
//        if (telp.isEmpty() || telp.length()<13 && telp.length()<12){
//            showError(etTelp,"Nomer Teleponmu Tidak Valid !");
//        }else if (sandi.isEmpty() || sandi.length()<6) {
//            showError(etSandi, "Kata Sandi Harus Lebih dari 6 Kalimat !");
//        }else {
//            DaftarRequest daftarRequest = new DaftarRequest();
//                    daftarRequest.setNama(etNama.getText().toString());
//                    daftarRequest.setAlamat(etAlamat.getText().toString());
//                    daftarRequest.setTelp(etTelp.getText().toString());
//                    daftarRequest.setSandi(etSandi.getText().toString());
////                    chekCredentials();
//                    daftarUser(daftarRequest);
//        }
//
//    }

//    public void showError(EditText input, String s) {
//        input.setError(s);
//        input.requestFocus();
//    }

    public void daftar(View view) {

        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        String telp = etTelp.getText().toString();
        String sandi = etSandi.getText().toString();

        if (TextUtils.isEmpty(sandi) || sandi.length()<8) {
            Toast.makeText(this, "Harus lebih dari 8", Toast.LENGTH_SHORT).show();
        }else {
            DaftarRequest daftarRequest = new DaftarRequest();
                    daftarRequest.setNama(etNama.getText().toString());
                    daftarRequest.setAlamat(etAlamat.getText().toString());
                    daftarRequest.setTelp(etTelp.getText().toString());
                    daftarRequest.setSandi(etSandi.getText().toString());
//                    chekCredentials();
                    daftarUser(daftarRequest);
        }

        Intent intent = new Intent( Daftar.this, Masuk.class);
        startActivity(intent);
    }

    public void masuk(View view) {
        Intent intent = new Intent( Daftar.this, Masuk.class);
        startActivity(intent);
    }

    public void daftarUser(DaftarRequest daftarRequest){
        Call<DaftarResponse> daftarResponseCall = ApiClient.getService().daftarUser(daftarRequest);
        daftarResponseCall.enqueue(new Callback<DaftarResponse>() {
            @Override
            public void onResponse(Call<DaftarResponse> call, Response<DaftarResponse> response) {

                if (response.isSuccessful()){

                    String pesan = "Daftar berhasil";
                    Toast.makeText(Daftar.this,pesan,Toast.LENGTH_LONG).show();

                    startActivity(new Intent(Daftar.this, Masuk.class));
                    finish();

                }else{
                    String pesan = "Daftar gagal, coba lagi";
                    Toast.makeText(Daftar.this,pesan,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<DaftarResponse> call, Throwable t) {

                String pesan = t.getLocalizedMessage();
                Toast.makeText(Daftar.this,pesan,Toast.LENGTH_LONG).show();

            }
        });
    }
}