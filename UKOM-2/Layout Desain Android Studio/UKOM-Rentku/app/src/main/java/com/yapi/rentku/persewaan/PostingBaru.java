package com.yapi.rentku.persewaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.MainActivity2;
import com.yapi.rentku.R;

public class PostingBaru extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting_baru);
    }

    public void postingbaru(View view) {
        Intent intent = new Intent( PostingBaru.this, Posting.class);
        startActivity(intent);
    }

    public void kembali(View view) {
        Intent intent = new Intent( PostingBaru.this, Posting.class);
        startActivity(intent);
    }
}