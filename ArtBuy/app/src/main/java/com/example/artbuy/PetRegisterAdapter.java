package com.example.artbuy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PetRegisterAdapter extends RecyclerView.Adapter<PetRegisterAdapter.CustomViewHolder>{
    public PetRegisterAdapter(ArrayList<PetRegiData> list, Context context) {
        super();
    }

    @NonNull
    @Override
    public PetRegisterAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PetRegisterAdapter.CustomViewHolder holder, int position) {
        // 실제 item이 화면에 추가될 때의 동작
//        holder.iv_profile.setImageURI(arrayList.get(position).getIv_profile());
//        holder.tv_name.setText(arrayList.get(position).getTv_name());
//        holder.tv_age.setText(arrayList.get(position).getTv_content());
    }

    @Override
    public void onBindViewHolder(@NonNull PetRegisterAdapter.CustomViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_age;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_pet_prifile);
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_pet_name);
            this.tv_age = (TextView) itemView.findViewById(R.id.tv_pet_age);
        }
    }
}
