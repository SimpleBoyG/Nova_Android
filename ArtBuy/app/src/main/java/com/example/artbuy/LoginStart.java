package com.example.artbuy;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginStart extends AppCompatActivity {


    private String LoginId = null;
    private String LoginPW = null;
    private String LoginNick = null;


    private ActivityResultLauncher<Intent> mSignUpActivityResult =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult a_result) {
                            if(a_result.getResultCode() == Activity.RESULT_OK) {

                                Intent SignUpIntent = a_result.getData();
                                LoginId = SignUpIntent.getStringExtra("ID");
                                LoginPW = SignUpIntent.getStringExtra("Password");
                                LoginNick = SignUpIntent.getStringExtra("NickName");
                            }
                        }
                    }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 로그인 버튼
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginStart.this, MainActivity.class);
                intent.putExtra("NickName",LoginNick);
                startActivity(intent);
                finish();
            }

        });

        // 회원가입 버튼
        Button btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginStart.this,SignUp.class);
                mSignUpActivityResult.launch(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(LoginId != null && LoginPW != null) {
            EditText edt_ID = (EditText) findViewById(R.id.edit_Id);
            EditText edt_Password = (EditText) findViewById(R.id.edit_Password);
            edt_ID.setText(LoginId);
            edt_Password.setText(LoginPW);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast ReturnToast = Toast.makeText(this.getApplicationContext(),"돌아오신걸 환영합니다.", Toast.LENGTH_SHORT);
        ReturnToast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}