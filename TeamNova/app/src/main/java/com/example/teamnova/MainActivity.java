package com.example.teamnova;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView 리싸이클러뷰;
    LinearLayoutManager 레이아웃매니저;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        리싸이클러뷰 = findViewById(R.id.recy);
        레이아웃매니저 = new LinearLayoutManager(this);
        리싸이클러뷰.setLayoutManager(레이아웃매니저);

    }
}