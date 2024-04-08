package com.example.artbuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CommunityForm extends AppCompatActivity {

    private String strSubject = null;
    private String strContent = null;

    private boolean bEndState = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_form);


        Button btnTextEnd = (Button) findViewById(R.id.btnTextEnd); // 작성완료 버튼
        Button btnCancle = (Button) findViewById(R.id.btnCFCancle); // 취소 버튼
        EditText edtSubJect = (EditText) findViewById(R.id.edtSubject);
        EditText edtContent = (EditText) findViewById(R.id.edtContent);

        btnTextEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strSubject = edtSubJect.getText().toString();
                strContent = edtContent.getText().toString();
                Intent intentCommuForm = new Intent(CommunityForm.this, Community.class);
                intentCommuForm.putExtra("Subject", strSubject);
                intentCommuForm.putExtra("Content", strContent);
                intentCommuForm.putExtra("TextEnd", true);
                startActivity(intentCommuForm);
                bEndState = true;
                finish();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancle_intent = new Intent(CommunityForm.this, Community.class);
                startActivity(cancle_intent);
                bEndState = false;
                finish();
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
//        Intent itt_BoolSend = new Intent(CommunityForm.this, Community.class);
//        itt_BoolSend.putExtra("TextState", true);
//        startActivity(itt_BoolSend);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bEndState == true){
            Toast EndToast = Toast.makeText(this.getApplicationContext(),"작성하신 글이 추가되었습니다.", Toast.LENGTH_SHORT);
            EndToast.show();
        }else{
            Toast EndToast = Toast.makeText(this.getApplicationContext(),"작성하신 글이 취소되었습니다.", Toast.LENGTH_SHORT);
            EndToast.show();
        }

    }
}
