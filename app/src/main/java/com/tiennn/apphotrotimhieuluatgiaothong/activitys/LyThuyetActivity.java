package com.tiennn.apphotrotimhieuluatgiaothong.activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tiennn.apphotrotimhieuluatgiaothong.R;

public class LyThuyetActivity extends AppCompatActivity {

    private ImageView imgReturn;
    private Button btn_tinhHuongHayGap,btn_videoHuongDan;
    private LinearLayout ll_lythuyet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly_thuyet);

        ll_lythuyet = findViewById(R.id.ll_lythuyet);
        Intent i4 = getIntent();
        int value = i4.getIntExtra("KEY",getResources().getColor(R.color.xanh1));
        ll_lythuyet.setBackgroundColor(value);

        imgReturn = findViewById(R.id.imgReturn);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LyThuyetActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btn_tinhHuongHayGap = findViewById(R.id.btn_tinhHuongHayGap);
        btn_videoHuongDan = findViewById(R.id.btn_videoHuongDan);

        btn_videoHuongDan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable colorDrawable =(ColorDrawable) ll_lythuyet.getBackground();
                int manau4 = colorDrawable.getColor();
                Intent i1 = new Intent(LyThuyetActivity.this,ListVideoActivity.class);
                i1.putExtra("KEY",manau4);
                startActivity(i1);
            }
        });

        btn_tinhHuongHayGap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable colorDrawable =(ColorDrawable) ll_lythuyet.getBackground();
                int manau5 = colorDrawable.getColor();
                Intent i2 = new Intent(LyThuyetActivity.this,TinhHuongHayGapActivity.class);
                i2.putExtra("KEY",manau5);
                startActivity(i2);
            }
        });

    }
}
