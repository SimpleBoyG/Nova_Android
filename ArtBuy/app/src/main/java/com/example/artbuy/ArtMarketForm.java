package com.example.artbuy;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ArtMarketForm extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_market_form);

        ImageButton btn_map = (ImageButton) findViewById(R.id.btn_ArtMarketForm_Map);
        Button btn_Cancel = (Button) findViewById(R.id.btn_ArtMarketForm_Cancel);
        Button btn_OK = (Button) findViewById(R.id.btn_ArtMarketForm_OK);

        // 지도 버튼
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
//                startActivity(intent);

                //'지도보기'를 위한 intent 생성
                Uri location = Uri.parse("geo:0,0?q=태평동 1007"); // Map point based on address
                //Uri location = Uri.parse("geo:37.566663, 126.978410?z=14"); //map point based on latitude/longitude. z param is zoom level
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                //인텐트를 수신할 앱이 있는지 확인
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                //인텐트를 처리할수있는 앱을 시작
                if (isIntentSafe) {
                    startActivity(mapIntent);
                }
            }
        });
        
        // 작성완료 버튼
        btn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        
        // 취소 버튼
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReturnIntent = new Intent(ArtMarketForm.this, ArtMarket.class);
                startActivity(ReturnIntent);
                finish();
            }
        });
    }
}
