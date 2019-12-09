package com.tiennn.apphotrotimhieuluatgiaothong.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.tiennn.apphotrotimhieuluatgiaothong.R;
import com.tiennn.apphotrotimhieuluatgiaothong.adapters.BienBaoAdapter;
import com.tiennn.apphotrotimhieuluatgiaothong.adapters.TinhHuongAdapter;
import com.tiennn.apphotrotimhieuluatgiaothong.models.BienBao;
import com.tiennn.apphotrotimhieuluatgiaothong.models.TinhHuong;

import java.util.ArrayList;

public class TinhHuongHayGapActivity extends AppCompatActivity {
    private ImageView imgReturn;
    private ListView lv_tinhHuong;
    private LinearLayout ll_tinhHuongHayGap;
    private ArrayList<TinhHuong> tinhHuongs;
    TinhHuongAdapter tinhHuongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_huong_hay_gap);

        ll_tinhHuongHayGap = findViewById(R.id.ll_tinhHuongHayGap);

        Intent i = getIntent();
        int value = i.getIntExtra("KEY",getResources().getColor(R.color.xanh1));
        ll_tinhHuongHayGap.setBackgroundColor(value);


        imgReturn = findViewById(R.id.imgReturn);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable colorDrawable =(ColorDrawable) ll_tinhHuongHayGap.getBackground();
                int manau6 = colorDrawable.getColor();
                Intent intent = new Intent(TinhHuongHayGapActivity.this, LyThuyetActivity.class);
                intent.putExtra("KEY",manau6);
                startActivity(intent);
            }
        });


        lv_tinhHuong = findViewById(R.id.lv_tinhHuong);

        tinhHuongs = new ArrayList<>();

        tinhHuongs.add(new TinhHuong(R.drawable.tinhhuong1,"Trong tình huống này: \nXe tải rẽ trái thì sẽ dừng sai vị trí\nXe khách đi thẳng đỗ sai vị trí\nXe con rẽ phải dừng đúng vị trí "));
        tinhHuongs.add(new TinhHuong(R.drawable.tinhhuong2,"Biển báo đi thẳng mà xe máy và xe ô tô có tín hiệu rẽ phải trái là sai quy định giao thông "));
        tinhHuongs.add(new TinhHuong(R.drawable.tinhhuong3,"Trong tình huống nay:\nXe mô tô được đi trước vì được ưu tiên cho xe cơ giới theo luật giao thông\n Tiếp đến là xe lam\nSau cùng là xe tải vì xe tải "));
        tinhHuongs.add(new TinhHuong(R.drawable.tinhhuong4,"Trong tình huống này:\nXe mô tô được phép đi trước vì xe mô tô rẽ phải gần đường đang đi\n Tiếp đến là xe tải vì xe tải đi thẳng và nhỏ\n Tiếp đến là xe khách vì xe khách đi thẳng\n Tiếp đến là xe con vì xe con quay đầu nên phải đi sau cùng "));


        tinhHuongAdapter = new TinhHuongAdapter(this,R.layout.item_tinhhuong,tinhHuongs);
        lv_tinhHuong.setAdapter(tinhHuongAdapter);

    }
}
