package com.yapi.rentku.dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yapi.rentku.R;
import com.yapi.rentku.model.GetNewPassword;
import com.yapi.rentku.model.LoginEmail;
import com.yapi.rentku.model.NewPPassword;
import com.yapi.rentku.rest.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PassLupaMasuk extends AppCompatActivity {
    EditText username, paassword, gmail;
    private Button button;
    LoginEmail getLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_lupa_masuk);
        paassword = findViewById(R.id.sandibaru);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            getLogin = (LoginEmail) intent.getSerializableExtra("data");
//            gmail.setText(getLogin.getEmail());
//            paassword.setText(getLogin.getPassword());
        }
        button = findViewById(R.id.btnganti);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewPPassword registerModel= new NewPPassword();


                registerModel.setSandi(paassword.getText().toString());

                Register(registerModel);


            }
        });
    }

    public void Register(NewPPassword newPPassword){
        Intent mIntent = getIntent();
        Integer id = getLogin.getId();
        Call<GetNewPassword> registerCall = ApiClient.getService().NewPassword(id,newPPassword);
        registerCall.enqueue(new Callback<GetNewPassword>() {
            @Override
            public void onResponse(Call<GetNewPassword> call, Response<GetNewPassword> response) {
                if (response.isSuccessful()){
                    startActivity(new Intent(PassLupaMasuk.this,Masuk.class));
                    finish();

                }else{
                    String  pesan1 = "Harus Diisi!";
                    Toast.makeText(PassLupaMasuk.this, pesan1, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetNewPassword> call, Throwable t) {
                Toast.makeText(PassLupaMasuk.this, "Harus DiIsi", Toast.LENGTH_SHORT).show();
            }
        });

    }

//    public void gantipw(View view) {
//        Intent intent = new Intent( PassLupaMasuk.this, Masuk.class);
//        startActivity(intent);
//    }
}