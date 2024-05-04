package com.example.artbuy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Daily extends AppCompatActivity implements onViewClickListener{

    private ArrayList<RecyclerViewData> arrayList;
    private DailyAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    int recyclerPostion = 0;
    boolean bModify = false;

    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        Bundle IsEmptyIntent = intent.getExtras();
                        if(IsEmptyIntent != null) {
                            String strName = intent.getStringExtra("name");
                            String strContent = intent.getStringExtra("content");
                            Uri uri = intent.getData();
                            RecyclerViewData recyclerViewData = new RecyclerViewData(uri, strName, strContent);
                            arrayListCheck(arrayList,recyclerPostion,recyclerViewData);

                            // 리사이클러뷰 업데이트
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
    );

    public void arrayListCheck(ArrayList<RecyclerViewData> arrayList, int position, RecyclerViewData recyclerViewData){
        // 추가 되는 요소가 존재 하지 않으면 추가
        if(bModify == false){
            arrayList.add(recyclerViewData);
        }else{
            arrayList.remove(position);
            arrayList.add(position,recyclerViewData);
            bModify = false;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        // 리사이클러뷰에 LinearLayoutManager 객체 지정
        recyclerView = findViewById(R.id.rcyCommunity);

        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager); // 레이아웃 매니저 셋

        arrayList = new ArrayList<>();

        // 리사이클러뷰에 mainAdapter 객체 지정
        adapter = new DailyAdapter(arrayList,this,this);
        recyclerView.setAdapter(adapter);

        // 애니메이션 버튼 클릭
        FloatingActionButton btn_Plus = (FloatingActionButton) findViewById(R.id.btnCommunityPlus);
        btn_Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Daily.this, DailyForm.class);
                activityResultLauncher.launch(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MyTag","OnDestroy");
    }

    @Override
    public void onUpdateBtnClick(DailyAdapter.CustomViewHolder holder, View view, int position) {
        Log.d("MyTag","Holder" + holder);
        Log.d("MyTag","View :"+ view);
        Log.d("MyTag","position :"+position);
        recyclerPostion = position;
        bModify = true;
        Intent intent = new Intent(Daily.this, DailyForm.class);
        activityResultLauncher.launch(intent);
    }
}
