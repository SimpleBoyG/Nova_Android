package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyTag";
    int iTemp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate" + iTemp);

    }

    @Override
    protected void onStart() {
        super.onStart();
        iTemp++;
        Log.d(TAG, "onStart" + iTemp);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        iTemp++;
        Log.d(TAG, "onReStart" + iTemp);
    }

    @Override
    protected void onResume() {
        super.onResume();
        iTemp++;
        Log.d(TAG, "onResume" + iTemp);
    }

    @Override
    protected void onPause() {
        super.onPause();
        iTemp++;
        Log.d(TAG, "onPause" + iTemp);
    }

    @Override
    protected void onStop() {
        super.onStop();
        iTemp++;
        Log.d(TAG, "onStop" + iTemp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iTemp++;
        Log.d(TAG, "onDestroy" + iTemp);
    }
}