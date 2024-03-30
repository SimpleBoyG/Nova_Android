package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText input;
    Button btn01, btn02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.textInputEditText);

        btn01 = (Button) findViewById(R.id.Move);
        btn02 = (Button) findViewById(R.id.close);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.Move){
            String temp = input.getText().toString();
            Intent intent01 = new Intent(this, Activity2.class);
            intent01.putExtra("key01",temp);
            startActivity(intent01);
        }
        if(v.getId() == R.id.close){
            finish();
        }
    }
}