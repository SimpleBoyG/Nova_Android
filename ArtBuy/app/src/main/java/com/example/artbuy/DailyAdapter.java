package com.example.artbuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.CustomViewHolder> {

    // 생성자에서 데이터 리스트 객체를 전달받음.
    ArrayList<RecyclerViewData> arrayList = new ArrayList<>();
    private Context context;

    DailyAdapter(ArrayList<RecyclerViewData> list, Context context) {
        arrayList = list ;
        this.context = context;
    }
    @NonNull
    @Override
    public DailyAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View View = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_daily_list_form, parent, false);

        return new DailyAdapter.CustomViewHolder(View);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyAdapter.CustomViewHolder holder, int position) {
        // 실제 item이 화면에 추가될 때의 동작

        //holder.iv_profile.setImageURI(arrayList.get(position).getIv_profile());
        holder.tv_name.setText(arrayList.get(position).getTv_name());
        holder.tv_content.setText(arrayList.get(position).getTv_content());

        Glide.with(holder.itemView.getContext())
                .load(arrayList.get(position).getIv_profile())
                .override(200,200)
                .into(holder.iv_profile);


        // 태그 지정
        holder.itemView.setTag(position);

        // 아이템 View가 짧게 클릭 됐을 때 아이템명을 띄움
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭한 item의 이름을 가져옴
                String curName = holder.tv_name.getText().toString() + "수정 합니다";
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();
                viewModify();
            }
        });

        // 아이템 View가 롱클릭 됐을 때 Item 제거
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // PopupMenu 객체 생성
                PopupMenu DailyPopup = new PopupMenu(context.getApplicationContext(), v); // 두 번째 파라미터가 팝업메뉴가 붙을 뷰
                DailyPopup.getMenuInflater().inflate(R.menu.daily_papup, DailyPopup.getMenu());
                DailyPopup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.daily_update){


                    }else{
                        remove(holder.getAdapterPosition());
                    }
                        return false;
                    }
                });
                DailyPopup.show();

                return true;
            }
        });
    }



    // item 제거
    public void remove(int position){
        try{
            arrayList.remove(position); // 제거
            notifyItemRemoved(position); // 새로고침
        } catch(IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {

        return (null != arrayList ? arrayList.size() : 0);
    }

    // RecyclerView.ViewHolder 상속
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_content;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }

    public void viewModify(){
        // 다이얼로그를 객체 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // View에 xml 연결
        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_daily_modify_form,null,false);
        // Builder에 View 설정
        builder.setView(view);

        // View 객체들 ID 설정
        final ImageView ibGallery = (ImageView) view.findViewById(R.id.ib_DailyModifyGallary);
        final EditText editTextSubject = (EditText) view.findViewById(R.id.edt_DailyModifySubject);
        final EditText editTextContent = (EditText) view.findViewById(R.id.edt_DailyModifyContent);
        final Button btnOK = (Button) view.findViewById(R.id.btn_ModifyTextEnd);
        final Button btnCancle = (Button) view.findViewById(R.id.btn_ModifyCancle);

        // builder 생성
        final AlertDialog dialog = builder.create();

        dialog.show();
    }
}
