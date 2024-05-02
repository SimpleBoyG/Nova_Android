package com.example.artbuy;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ArtMarket extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_pet);

        ImageButton btnBack = (ImageButton)  findViewById(R.id.btn_ArtMarket_Back);
        FloatingActionButton btnFormCreate = (FloatingActionButton) findViewById(R.id.btn_ArtMarket_FormCreate);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnFormCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ArtMarketForm.class);
                startActivity(intent);
            }
        });

        //SearchView svArtList = (SearchView) findViewById(R.id.searchView);

        //svArtList.setSubmitButtonEnabled(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
