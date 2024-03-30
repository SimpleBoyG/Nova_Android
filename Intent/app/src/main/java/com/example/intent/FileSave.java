package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FileSave extends AppCompatActivity implements View.OnClickListener {

    // 저장할 내용이 있을 때 저장할 파일명
    private static final String LOCAL_FILE = "memo_data.txt";
    // 액티비치 요청 구분자
    private static final int Start_Activity = 1;

    // 레이아웃 객체와 연결한 변수 선언
    EditText edit01;
    Button s_btn, c_btn, f_btn, at_btn;

    private ActivityResultLauncher<Intent> mPreContractStartActivityResult =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult a_result) {
                            if (a_result.getResultCode() == FileSave2.RESULT_OK) {
                                String result = a_result.getData().getExtras().getString(FileSave2.Set_Text);
                                edit01.append(result);

                            }
                        }
                    }
            );

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_test);

        // 레이아웃과 연결
        edit01 = (EditText) findViewById(R.id.editTesx01);
        s_btn = (Button) findViewById(R.id.s_button);
        c_btn = (Button) findViewById(R.id.c_button);
        f_btn = (Button) findViewById(R.id.f_button);
        at_btn = (Button) findViewById(R.id.at_button);

        // 버튼 리스너 등록
        s_btn.setOnClickListener(this);
        c_btn.setOnClickListener(this);
        f_btn.setOnClickListener(this);
        at_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        // DIAL로 전환
        if (v.getId() == R.id.s_button) {
//            Intent intent = new Intent(Intent.ACTION_DIAL);
//            startActivity(intent);
            String url ="http://google.com";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);

        }

        // clear 버튼으로 초기화
        if (v.getId() == R.id.c_button) {
            edit01.setText("");
        }

        // finish 버튼으로 종료
        if (v.getId() == R.id.f_button) {
            finish();
        }

        // addtext 버튼으로 두번쨰 액티비티에서 추가할 text를 받아서 작성
        if (v.getId() == R.id.at_button) {
            Intent intent = new Intent(this, FileSave2.class);
            mPreContractStartActivityResult.launch(intent);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 어떤 액티비티가 종료했는지 구분
        if (requestCode == Start_Activity) {
            if (resultCode != RESULT_OK) {
                edit01.append("/n");
            } else {
                String result = data.getExtras().getString(FileSave2.Set_Text);
                edit01.append(result);
            }
        }
    }
}
