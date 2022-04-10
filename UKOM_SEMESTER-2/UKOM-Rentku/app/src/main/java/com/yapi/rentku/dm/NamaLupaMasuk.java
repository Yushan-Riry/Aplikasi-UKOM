package com.yapi.rentku.dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yapi.rentku.R;
import com.yapi.rentku.model.GetLoginEmail;
import com.yapi.rentku.model.LoginEmail;
import com.yapi.rentku.rest.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NamaLupaMasuk extends AppCompatActivity {
    EditText username, paassword, gmail;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nama_lupa_masuk);
        gmail = findViewById(R.id.namaakun);
        button = findViewById(R.id.btnlanjut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginEmail login = new LoginEmail();
                login.setNama(gmail.getText().toString());

                LoginUser(login);
            }
        });
    }

    public void LoginUser(LoginEmail loginEmail) {
        Call<GetLoginEmail> loginCall = ApiClient.getService().loginEmail(loginEmail);
        loginCall.enqueue(new Callback<GetLoginEmail>() {
            @Override
            public void onResponse(Call<GetLoginEmail> call, Response<GetLoginEmail> response) {
                if (response.isSuccessful()) {
                    LoginEmail getLogin = response.body().getData();
                    startActivity(new Intent(NamaLupaMasuk.this, PassLupaMasuk.class).putExtra("data", getLogin));
                    finish();


                } else {
                    String pesan1 = "gagal";
                    Toast.makeText(NamaLupaMasuk.this, pesan1, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetLoginEmail> call, Throwable t) {
                String pesan = "Nama Belum Terdaftar";
                Toast.makeText(NamaLupaMasuk.this, pesan, Toast.LENGTH_SHORT).show();

            }
        });
    }

//    public void lanjut(View view) {
//        Intent intent = new Intent( NamaLupaMasuk.this, PassLupaMasuk.class);
//        startActivity(intent);
//    }

}