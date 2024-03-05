package com.example.teamnova;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(parent,false);
//        return new Adapter().CustomViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView 학생이름뷰;
        Button 출석버튼;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            학생이름뷰 = itemView.findViewById(R.id.textView);
            //출석버튼 = itemView.findViewById(R.id.button)
        }
    }
}
