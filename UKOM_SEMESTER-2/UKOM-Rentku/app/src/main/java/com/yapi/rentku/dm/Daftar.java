package com.yapi.rentku.dm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.yapi.rentku.R;
import com.yapi.rentku.rest.ApiClient;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Daftar extends AppCompatActivity {

    Button btnDaftar,generateOTPBtn;
    EditText etNama, etAlamat, etTelp, etSandi,edtOTP;

    // captcha
    String SITE_KEY = "6LfT6HseAAAAAP-nT-RS22dsGiNJmrfopjx_daOH";
    String SECRET_KEY = "6LfT6HseAAAAAH-PW4iGLf3_VZmONLnMUcOizGcF";

    RequestQueue queue;
    private FirebaseAuth mAuth;
    private String verificationId;
//    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        btnDaftar = findViewById(R.id.btndaftar);
        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etTelp = findViewById(R.id.etTelp);
        etSandi = findViewById(R.id.etSandi);
        mAuth = FirebaseAuth.getInstance();
        edtOTP = findViewById(R.id.etSandi2);
        generateOTPBtn = findViewById(R.id.btndaftar2);

        queue = Volley.newRequestQueue(getApplicationContext());

        generateOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // below line is for checking weather the user
                // has entered his mobile number or not.
                if (TextUtils.isEmpty(etTelp.getText().toString())) {
                    // when mobile number text field is empty
                    // displaying a toast message.
                    Toast.makeText(Daftar.this, "Masukkan Telpon yang Benar !", Toast.LENGTH_SHORT).show();
                } else {
                    // if the text field is not empty we are calling our
                    // send OTP method for getting OTP from Firebase.
                    String phone = "+62" + etTelp.getText().toString();
                    sendVerificationCode(phone);
                }
            }
        });


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

        //babak penentuan

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass = etSandi.getText().toString();

                // Kode OTP
                if (TextUtils.isEmpty(edtOTP.getText().toString())) {
                    Toast.makeText(Daftar.this, "Masukkan OTP terlebih dahulu !", Toast.LENGTH_SHORT).show();
                } else {
                    verifyCode(edtOTP.getText().toString());
                }


                // Nama dan password secure
                if (TextUtils.isEmpty(etNama.getText().toString()) || TextUtils.isEmpty(etAlamat.getText().toString())
                        || TextUtils.isEmpty(etTelp.getText().toString()) || TextUtils.isEmpty(etSandi.getText().toString())) {

                    String pesan = "Isi semua data terlebih dahulu !";
//                    Toast.makeText(Daftar.this, pesan, Toast.LENGTH_LONG).show();

                }else if(TextUtils.isEmpty(pass) || pass.length()<7 || !etSandi.getText().toString().matches("[a-z,A-Z,0-9]*")){
                    etSandi.setError("Minimal 7 & Jangan Menggunakan Simbol !");

                    // secure biar unik
//                }else if(TextUtils.isEmpty(pass) || pass.length()<7 || !etSandi.getText().toString().matches("(?=.[0-9])" +
//                        "(?=.*[a-z])" +
//                        "(?=.*[A-Z])" +
//                        "(?=.*[a-zA-Z])"
//                        //"(?=.[@#%^&+=_])" +
//                        //"(?=\\S+$)" +
//                        //".{8,}" +
//                        //"$"
 //               )){
                    etSandi.setError("Minimal 7. Kombinasi Angka, Huruf, dan Simbol !");
//
                    // secure sandi lama
//
                }else {
                    verifyGoogleReCAPTCHA();
                    verifyCode(edtOTP.getText().toString());
//                    DaftarRequest daftarRequest = new DaftarRequest();
//                    daftarRequest.setNama(etNama.getText().toString());
//                    daftarRequest.setAlamat(etAlamat.getText().toString());
//                    daftarRequest.setTelp(etTelp.getText().toString());
//                    daftarRequest.setSandi(etSandi.getText().toString());
//
//                    daftarUser(daftarRequest);

                }

            }
        });
    }

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
                    String pesan = "Daftar gagal :(, coba lagi";
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

    private void verifyGoogleReCAPTCHA() {

        // below line is use for getting our safety
        // net client and verify with reCAPTCHA
        SafetyNet.getClient(this).verifyWithRecaptcha(SITE_KEY)
                // after getting our client we have
                // to add on success listener.
                .addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                    @Override
                    public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                        //Toast.makeText(Daftar.this, "hdgsj", Toast.LENGTH_SHORT).show();
                        // in below line we are checking the response token.
                        if (!response.getTokenResult().isEmpty()) {
                            // if the response token is not empty then we
                            // are calling our verification method.
                            //Toast.makeText(Daftar.this, "Maausj", Toast.LENGTH_SHORT).show();
                            handleVerification(response.getTokenResult());
                            DaftarRequest daftarRequest = new DaftarRequest();
                            daftarRequest.setNama(etNama.getText().toString());
                            daftarRequest.setAlamat(etAlamat.getText().toString());
                            daftarRequest.setTelp(etTelp.getText().toString());
                            daftarRequest.setSandi(etSandi.getText().toString());

                            daftarUser(daftarRequest);
                        }else{
                            Log.d("sd","Gagal");

                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // this method is called when we get any error.
                        if (e instanceof ApiException) {
                            ApiException apiException = (ApiException) e;
                            // below line is use to display an error message which we get.
                            Log.d("TAG", "Error message1: " +
                                    CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));
                        } else {
                            // below line is use to display a toast message for any error.
                            Toast.makeText(Daftar.this, "Error found is : " + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    protected void handleVerification(final String responseToken) {
        // inside handle verification method we are
        // verifying our user with response token.
        // url to sen our site key and secret key
        // to below url using POST method.
        String url = "https://www.google.com/recaptcha/api/siteverify";

        // in this we are making a string request and
        // using a post method to pass the data.
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // inside on response method we are checking if the
                        // response is successful or not.
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getBoolean("success")) {
                                // if the response is successful then we are
                                // showing below toast message.
//                                DaftarRequest daftarRequest = new DaftarRequest();
//                                daftarRequest.setNama(etNama.getText().toString());
//                                daftarRequest.setAlamat(etAlamat.getText().toString());
//                                daftarRequest.setSandi(etSandi.getText().toString());
//                                daftarRequest.setTelp(etTelp.getText().toString());
//                                daftarUser(daftarRequest);
                                Toast.makeText(Daftar.this, "Berhasil !", Toast.LENGTH_SHORT).show();
                            } else {
                                // if the response if failure we are displaying
                                // a below toast message.
                                Toast.makeText(getApplicationContext(), String.valueOf(jsonObject.getString("error-codes")), Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception ex) {
                            // if we get any exception then we are
                            // displaying an error message in logcat.
                            Log.d("TAG", "JSON exception: " + ex.getMessage());
                        }
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // inside error response we are displaying
                        // a log message in our logcat.
                        Log.d("TAG", "Error message: " + error.getMessage());
                    }
                }) {
            // below is the getParamns method in which we will
            // be passing our response token and secret key to the above url.
            @Override
            protected Map<String, String> getParams() {
                // we are passing data using hashmap
                // key and value pair.
                Map<String, String> params = new HashMap<>();
                params.put("secret", SECRET_KEY);
                params.put("response", responseToken);
                return params;
            }
        };
        // below line of code is use to set retry
        // policy if the api fails in one try.
        request.setRetryPolicy(new DefaultRetryPolicy(
                // we are setting time for retry is 5 seconds.
                50000,

                // below line is to perform maximum retries.
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // at last we are adding our request to queue.
        queue.add(request);
    }

    public void otp(View view) {
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        // inside this method we are checking if
        // the code entered is correct or not.
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            verifyGoogleReCAPTCHA();
                            // if the code is correct and the task is successful
                            // we are sending our user to new activity.
//                            Intent i = new Intent(RegisterActivity.this, HomeUtamaActivity.class);

//                            startActivity(i);

                        } else {
                            // if the code is not correct then we are
                            // displaying an error message to the user.
                            Toast.makeText(Daftar.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void sendVerificationCode(String number) {
        // this method is used for getting
        // OTP on user phone number.

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(number)            // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallBack)           // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks

            // initializing our callbacks for on
            // verification callback method.
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        // below method is used when
        // OTP is sent from Firebase
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            // when we receive the OTP it
            // contains a unique id which
            // we are storing in our string
            // which we have already created.
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            // below line is used for getting OTP code
            // which is sent in phone auth credentials.
            final String code = phoneAuthCredential.getSmsCode();

            // checking if the code
            // is null or not.
            if (code != null) {
                // if the code is not null then
                // we are setting that code to
                // our OTP edittext field.
                edtOTP.setText(code);
                // kode 1 otp

                // after setting this code
                // to OTP edittext field we
                // are calling our verifycode method.
                verifyCode(code);
            }
        }


        @Override
        public void onVerificationFailed(FirebaseException e) {
            // displaying error message with firebase exception.
            Toast.makeText(Daftar.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    private void verifyCode(String code) {
        // below line is used for getting getting
        // credentials from our verification id and code.
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

        // after getting credential we are
        // calling sign in method.
        signInWithCredential(credential);
    }

}