package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FileSave2 extends AppCompatActivity implements View.OnClickListener{
    public static final String Set_Text = "SetText";
    EditText editText01;
    Button btn01;

    String result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_test2);

        editText01 = (EditText) findViewById(R.id.editText02);
        btn01 = (Button) findViewById(R.id.close_btn);
        btn01.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        result = editText01.getText().toString();
        // 리턴할 결과를 setResult로 셋팅
        if(result.length() != 0){
            Intent intent01 = new Intent();
            intent01.putExtra(Set_Text, result);
            setResult(RESULT_OK, intent01);
        }else{
            setResult(RESULT_CANCELED);
        }
        finish();
    }
}
