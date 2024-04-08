package com.example.activityforresult;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class subActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("result","");
        setResult(RESULT_OK,resultIntent);
        finish();
    }


}
