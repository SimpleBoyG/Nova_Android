package com.example.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
    }

    public void onButton1Clicked(View v){
        changeImage(v);
    }

    private void changeImage(View v){
        if(imageIndex == 0){
            imageView.setVisibility(v.VISIBLE);
            imageView2.setVisibility(v.INVISIBLE);

            imageIndex = 1;
        }else if(imageIndex == 1){
            imageView.setVisibility(v.INVISIBLE);
            imageView2.setVisibility(v.VISIBLE);

            imageIndex = 0;
        }
    }
}
