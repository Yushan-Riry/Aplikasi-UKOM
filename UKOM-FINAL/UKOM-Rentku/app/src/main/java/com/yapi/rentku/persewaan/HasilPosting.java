package com.yapi.rentku.persewaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;

public class HasilPosting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_posting);
    }

    public void edit(View view) {
        Intent intent = new Intent( HasilPosting.this, PostingEdit.class);
        startActivity(intent);
    }

    public void hapus(View view) {
        Intent intent = new Intent( HasilPosting.this, Posting.class);
        startActivity(intent);
    }

    public void kembali(View view) {
        Intent intent = new Intent( HasilPosting.this, Posting.class);
        startActivity(intent);
    }
}