package com.example.artbuy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    final String checkID = "wjdwnstkd123";
    private String ID = "";
    private String Password = "";
    private String NickName = "";
    private String PasswordCheck = "";
    Intent intent;

    private boolean bCheckId = false;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);

        // 중복확인 버튼
        Button btnCheckId = (Button) findViewById(R.id.btnCheckId);
        btnCheckId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ID 가져오기
                EditText edtId = (EditText)findViewById(R.id.editId);
                ID = edtId.getText().toString();
                if(ID.equals(checkID)) {
                    builder.setTitle("알림");
                    builder.setMessage("사용할 수 없는 아이디 입니다.");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else{
                    bCheckId = true;
                    builder.setTitle("알림");
                    builder.setMessage("사용할 수 있는 아이디 입니다.");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

        // 가입하기 버튼
        Button btnSignUp = (Button) findViewById(R.id.btnJoin);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bCheckId == true) {
                    // ID 가져오기
                    EditText edtId = (EditText) findViewById(R.id.editId);
                    ID = edtId.getText().toString();
                    // 패스워드 가져오기
                    EditText edtPassword = (EditText) findViewById(R.id.editPassword);
                    Password = edtPassword.getText().toString();
                    // 재확인 패스워드 가져오기
                    EditText edtPasswordCheck = (EditText) findViewById(R.id.editPasswordCheck);
                    PasswordCheck = edtPasswordCheck.getText().toString();
                    // 닉네임 가져오기
                    EditText edtNickName = (EditText) findViewById(R.id.editNick);
                    NickName = edtNickName.getText().toString();

                    if (Password.equals(PasswordCheck)) {
                        // 액티비티 종료시 loginStart로 데이터 전달
                        Intent resultIntent = new Intent(SignUp.this, LoginStart.class);
                        resultIntent.putExtra("ID", ID);
                        resultIntent.putExtra("Password", Password);
                        resultIntent.putExtra("NickName", NickName);
                        setResult(RESULT_OK,resultIntent);

                        finish();

                    } else {
                        // 패스워드 재확인 알림
                        builder.setTitle("알림");
                        builder.setMessage("패스워드가 동일하지 않습니다.");
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }else{
                    // 아이디 중복확인 알림
                    builder.setTitle("알림");
                    builder.setMessage("아이디 중복확인을 해주세요");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

        // 취소 버튼
        Button btnCancle = (Button) findViewById(R.id.btnCancel);
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

}
