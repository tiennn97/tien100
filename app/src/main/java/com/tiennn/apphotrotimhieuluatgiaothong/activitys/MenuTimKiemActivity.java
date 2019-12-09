package com.tiennn.apphotrotimhieuluatgiaothong.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tiennn.apphotrotimhieuluatgiaothong.R;

public class MenuTimKiemActivity extends AppCompatActivity {

    private ImageView imgReturn;
    private Button btn_video,btn_luat,btn_bienbao;
    private LinearLayout ll_menutimkiem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tim_kiem);

        ll_menutimkiem = findViewById(R.id.ll_menutimkiem);
        Intent i5 = getIntent();
        int value = i5.getIntExtra("KEY",getResources().getColor(R.color.xanh1));
        ll_menutimkiem.setBackgroundColor(value);



        btn_video = findViewById(R.id.btn_video);
        btn_luat = findViewById(R.id.btn_luat);
        btn_bienbao = findViewById(R.id.btn_bienbao);

        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable colorDrawable =(ColorDrawable) ll_menutimkiem.getBackground();
                int manau3 = colorDrawable.getColor();
                Intent i1 = new Intent(MenuTimKiemActivity.this,TimKiemActivity.class);
                i1.putExtra("KEY1",manau3);
                startActivity(i1);
            }
        });

        btn_luat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable colorDrawable =(ColorDrawable) ll_menutimkiem.getBackground();
                int manau3 = colorDrawable.getColor();
                Intent i2 = new Intent(MenuTimKiemActivity.this,TimKiemLuatActivity.class);
                i2.putExtra("KEY1",manau3);
                startActivity(i2);
            }
        });

        btn_bienbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable colorDrawable =(ColorDrawable) ll_menutimkiem.getBackground();
                int manau3 = colorDrawable.getColor();
                Intent i3 = new Intent(MenuTimKiemActivity.this,TimKiemBienBaoActivity.class);
                i3.putExtra("KEY1",manau3);
                startActivity(i3);
            }
        });



        imgReturn = findViewById(R.id.imgReturn);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuTimKiemActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
