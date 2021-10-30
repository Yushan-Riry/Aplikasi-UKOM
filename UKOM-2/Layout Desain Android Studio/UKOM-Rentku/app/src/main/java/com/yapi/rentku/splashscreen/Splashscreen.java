package com.yapi.rentku.splashscreen;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.yapi.rentku.R;
import com.yapi.rentku.dm.Masuk;


public class Splashscreen extends Activity {

    //set waktu lama splashscreen
    private static int LamaTampilSplash = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // to do auto generated stub
                Intent intent = new Intent(Splashscreen.this, Masuk.class);
                startActivity(intent);

                this.selesai();
            }

            private void selesai(){

            }
        },LamaTampilSplash);

    };

}
