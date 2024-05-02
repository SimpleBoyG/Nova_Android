package com.example.artbuy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DailyForm extends AppCompatActivity {
    // 갤러리 접근 변수
    private final int GET_GALLERY_IMAGE=200;
    private String strName = null;
    private String strContent = null;
    private Uri uri = null;

    private boolean bEndState = false;

    // 갤러리에서 선택한 사진의 URI를 가져오는 코드
    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        uri = intent.getData();
                    }
                }
            }
    );
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_form);

        EditText edtName = (EditText) findViewById(R.id.edtDailySubject);
        EditText edtContent = (EditText) findViewById(R.id.edtDailyContent);
        Button btnTextEnd = (Button) findViewById(R.id.btnTextEnd); // 작성완료 버튼
        Button btnCancle = (Button) findViewById(R.id.btnCFCancle); // 취소 버튼
        ImageButton btnGallary = (ImageButton) findViewById(R.id.ib_DailyGallary);

        // 갤러리 이미지 불러오기
        btnGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GallaryInt = new Intent(Intent.ACTION_PICK);
                GallaryInt.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                GallaryInt.setAction(Intent.ACTION_PICK);
                activityResultLauncher.launch(GallaryInt);

            }
        });

        
        // 작성 완료
        btnTextEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strName = edtName.getText().toString();
                strContent = edtContent.getText().toString();
                Intent intentCommuForm = new Intent(DailyForm.this, Daily.class);
                intentCommuForm.putExtra("name", strName);
                intentCommuForm.putExtra("content", strContent);
                intentCommuForm.setData(uri);
                setResult(RESULT_OK,intentCommuForm);
                bEndState = true;
                finish();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancle_intent = new Intent(DailyForm.this, Daily.class);
                startActivity(cancle_intent);
                bEndState = false;
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ImageButton btnGallary = (ImageButton) findViewById(R.id.ib_DailyGallary);
        if(uri != null){
            btnGallary.setImageURI(uri);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
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
