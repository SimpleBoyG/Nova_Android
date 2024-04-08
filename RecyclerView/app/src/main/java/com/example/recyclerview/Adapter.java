package com.example.recyclerview;

import static android.app.ProgressDialog.show;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {

    @NonNull
    // 어떤 레이아웃을 사용해서 만들꺼니? R -> resource
    // ViewGroup는 RecyclerView
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 화면 하나가 담긴다
        // context는 현재 속해있는 액티비티
        // LayoutInflater.from(parent.getContext()) 리사이클러뷰가 속해있는 액팀비티를 가져온다.
        // inflate -> 팽창
        // .inflate(R.layout.student, parent, false);
        View 뷰하나 = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student, parent, false);

//        LayoutInflater 인플레이터 = LayoutInflater.from(parent.getContext());
//        View 뷰하나1 = 인플레이터.inflate((R.layout.student, parent,false));

        return new Adapter.CustomViewHolder(뷰하나);
    }

    String[] 학생이름배열 = {"손태영", "배수정", "이진형", "박훈성", "정준상"};
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.학생이름뷰.setText(학생이름배열[position]);
        holder.출석버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), ""+학생이름배열[position],
                Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 학생이름배열.length;
    }

    // 이너클래스
    // 뷰를 가지고 있다
    // 해당 뷰에 어떤 컴포넌트를 사용할 것인지 지정
    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView 학생이름뷰;
        Button 출석버튼;
        public CustomViewHolder(@NonNull View itemView){
            super(itemView);
            학생이름뷰 = itemView.findViewById(R.id.textView);
            출석버튼 = itemView.findViewById(R.id.button);
        }
    }
}
