package com.example.artbuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String LoginNickName = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView NickText = (TextView) findViewById(R.id.txtNick);

        // 회원가입시 입력한 NickName을 화면에 표시
        Intent loginIntent = getIntent();
        LoginNickName = "안녕하세요. " + loginIntent.getStringExtra("NickName") + " 님";
        NickText.setText(LoginNickName);


        ImageButton btnCommunity = (ImageButton) findViewById((R.id.btnComunity));
        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Daily.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast ReturnToast = Toast.makeText(this.getApplicationContext(),"돌아오신걸 환영합니다.", Toast.LENGTH_SHORT);
        ReturnToast.show();
    }
}
