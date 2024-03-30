package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    Button btn01;
    TextView result_textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_test);

        btn01 = (Button) findViewById(R.id.button3);
        btn01.setOnClickListener(this);

        result_textView = (TextView) findViewById(R.id.MessageTextView);

        Intent receive_intent = getIntent();
        String temp = receive_intent.getStringExtra("key01");
        result_textView.setText(temp);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
