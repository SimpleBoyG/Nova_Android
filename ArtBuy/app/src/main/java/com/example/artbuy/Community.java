package com.example.artbuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Community extends AppCompatActivity {

    private boolean m_bModify = false;
    private String m_strSubject = null;
    private String m_strContent = null;
    private Intent intentForm = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        // 애니메이션 버튼 클릭
        FloatingActionButton btn_Plus = (FloatingActionButton) findViewById(R.id.btnCommunityPlus);
        btn_Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Community.this, CommunityForm.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        intentForm = getIntent();
        m_bModify = intentForm.getBooleanExtra("TextEnd",false);
        if(m_bModify == true)
        {

            TextView txtSub = (TextView) findViewById(R.id.txtSubject);
            TextView txtCont = (TextView) findViewById(R.id.txtContent);

            m_strSubject = intentForm.getStringExtra("Subject").toString();
            m_strContent = intentForm.getStringExtra("Content").toString();
            txtSub.setText(m_strSubject);
            txtCont.setText(m_strContent);
            m_bModify = false;
        }
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
    }

}
