package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LinearLayout mainLayout = new LinearLayout(this);
//        mainLayout.setOrientation(LinearLayout.VERTICAL);
//
//        LinearLayout.LayoutParams params =
//                new LinearLayout.LayoutParams(
//                        ViewGroup.LayoutParams.WRAP_CONTENT,
//                        ViewGroup.LayoutParams.WRAP_CONTENT
//                );
//
//        Button button01 = new Button(this);
//        button01.setText("Button01");
//        button01.setLayoutParams(params);
//        mainLayout.addView(button01);
//
//        Button button02 = new Button(this);
//        button02.setText("Button02");
//        button02.setLayoutParams(params);
//        mainLayout.addView(button02);
//
//        Button button03 = new Button(this);
//        button03.setText("Button03");
//        button03.setLayoutParams(params);
//        mainLayout.addView(button03);
//
//        setContentView(mainLayout);

    }
}