package com.yapi.rentku.persewaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yapi.rentku.R;

public class PostingEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting_edit);
    }

    public void postingedit(View view) {
        Intent intent = new Intent( PostingEdit.this, HasilPosting.class);
        startActivity(intent);
    }

    public void kembali(View view) {
        Intent intent = new Intent( PostingEdit.this, HasilPosting.class);
        startActivity(intent);
    }
}