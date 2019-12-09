package com.tiennn.apphotrotimhieuluatgiaothong.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tiennn.apphotrotimhieuluatgiaothong.R;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout btn_traCuuLuat,btn_timKiem;
    private LinearLayout btn_bienBao,btn_hoiDapNhanh,btnLyThuyet,btnListVideo;
    private ImageView img_setting,img_setting2,img_lythuyet,img_video,img_hoiDapNhanh,img_BienBao,img_traCuuLuat,img_timKiem;
    private Button btn_lythuyet2,btn_listVideo2,btn_hoidapnhanh2,btn_BienBao2,btn_traCuuLuat2,btn_timKiem2;
    private RelativeLayout rl_header;
    private LinearLayout linearlayout;
    private ArrayList<Integer> arrayList;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        sharedPreferences = getSharedPreferences("saveData",MODE_PRIVATE);

        // lay gia tri sharedPreferences

        int c = sharedPreferences.getInt("mamau1",getResources().getColor(R.color.xanh1));
        rl_header.setBackgroundColor(c);
        btnLyThuyet.setBackgroundColor(c);
        img_lythuyet.setBackgroundColor(c);
        btn_lythuyet2.setBackgroundColor(c);

        img_video.setBackgroundColor(c);
        btn_listVideo2.setBackgroundColor(c);
        btnListVideo.setBackgroundColor(c);

        btn_hoiDapNhanh.setBackgroundColor(c);
        img_hoiDapNhanh.setBackgroundColor(c);
        btn_hoidapnhanh2.setBackgroundColor(c);

        btn_bienBao.setBackgroundColor(c);
        btn_BienBao2.setBackgroundColor(c);
        img_BienBao.setBackgroundColor(c);

        btn_traCuuLuat.setBackgroundColor(c);
        btn_traCuuLuat2.setBackgroundColor(c);
        img_traCuuLuat.setBackgroundColor(c);

        btn_timKiem.setBackgroundColor(c);
        btn_timKiem2.setBackgroundColor(c);
        img_timKiem.setBackgroundColor(c);

        int chon = sharedPreferences.getInt("chon",1);
        if (chon == 2){
            img_setting2.setVisibility(View.VISIBLE);
            img_setting.setVisibility(View.GONE);
        }else if (chon == 1){
            img_setting2.setVisibility(View.GONE);
            img_setting.setVisibility(View.VISIBLE);
        }

    }
    private void initViews(){
        btn_traCuuLuat = findViewById(R.id.btn_traCuuLuat);
        btn_bienBao = findViewById(R.id.btn_BienBao);
        btn_hoiDapNhanh = findViewById(R.id.btn_hoidapnhanh);
        btnLyThuyet = findViewById(R.id.btnLyThuyet);
        btnListVideo = findViewById(R.id.btn_listVideo);
        btn_timKiem = findViewById(R.id.btn_timKiem);
        img_setting = findViewById(R.id.img_setting);
        img_setting2 = findViewById(R.id.img_setting2);
        rl_header = findViewById(R.id.rl_header);
        img_lythuyet = findViewById(R.id.img_lythuyet);
        btn_lythuyet2 = findViewById(R.id.btn_lythuyet2);
        img_video = findViewById(R.id.img_video);
        btn_listVideo2 = findViewById(R.id.btn_btn_listVideo2);
        img_hoiDapNhanh = findViewById(R.id.img_hoidapnhanh);
        btn_hoidapnhanh2 = findViewById(R.id.btn_hoidapnhanh2);
        img_BienBao = findViewById(R.id.img_BienBao);
        btn_BienBao2 = findViewById(R.id.btn_BienBao2);
        img_traCuuLuat = findViewById(R.id.img_traCuuLuat);
        btn_traCuuLuat2 = findViewById(R.id.btn_traCuuLuat2);
        img_timKiem = findViewById(R.id.img_timKiem);
        btn_timKiem2 = findViewById(R.id.btn_timKiem2);


        btn_traCuuLuat.setOnClickListener(this);
        btn_bienBao.setOnClickListener(this);
        btn_hoiDapNhanh.setOnClickListener(this);
        btnLyThuyet.setOnClickListener(this);
        btnListVideo.setOnClickListener(this);
        btn_timKiem.setOnClickListener(this);
        img_setting.setOnClickListener(this);
        img_setting2.setOnClickListener(this);

        linearlayout = findViewById(R.id.linearLayout);
        arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg_anh1);
        arrayList.add(R.drawable.bg_anh2);
        arrayList.add(R.drawable.anh);
        arrayList.add(R.drawable.bg_anh3);
        arrayList.add(R.drawable.bg_anh4);
        arrayList.add(R.drawable.bg_anh5);
        arrayList.add(R.drawable.bg_anh6);

        linearlayout.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Random random = new Random();
                int bg = random.nextInt(arrayList.size());
                linearlayout.setBackgroundResource(arrayList.get(bg));


            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_traCuuLuat:
                startTraCuuLuat();
                break;
            case R.id.btn_BienBao:
                startBienBao();
                break;
            case R.id.btn_hoidapnhanh:
                startHoiDapNhanh();
                break;
            case R.id.btn_listVideo:
                startVideo();
                break;
            case R.id.btnLyThuyet:
                startLyThuyet();
                break;
            case R.id.btn_timKiem:
                startTimKiem();
                break;
            case R.id.img_setting:
                showMenu();
                break;
            case R.id.img_setting2:
                showMenu1();

                break;
            default:
                break;
        }
    }
    private void startTraCuuLuat(){
        ColorDrawable colorDrawable =(ColorDrawable) rl_header.getBackground();
        int manau = colorDrawable.getColor();
        Intent i = new Intent(MainActivity.this, LuatListActivity.class);
        i.putExtra("KEY",manau);
        startActivity(i);
    }
    private void startBienBao(){
        ColorDrawable colorDrawable =(ColorDrawable) rl_header.getBackground();
        int manau = colorDrawable.getColor();
        Intent i1 = new Intent(MainActivity.this, BienBaoListActivity.class);
        i1.putExtra("KEY",manau);
        startActivity(i1);
    }
    private void startHoiDapNhanh(){
        ColorDrawable colorDrawable =(ColorDrawable) rl_header.getBackground();
        int manau = colorDrawable.getColor();
        Intent i2 = new Intent(MainActivity.this, CauHoiActivity.class);
        i2.putExtra("KEY",manau);
        startActivity(i2);
    }
    private void startVideo(){
        ColorDrawable colorDrawable =(ColorDrawable) rl_header.getBackground();
        int manau = colorDrawable.getColor();
        Intent i3 = new Intent(MainActivity.this, ListVideoActivity.class);
        i3.putExtra("KEY",manau);
        startActivity(i3);
    }
    private void startLyThuyet(){
        ColorDrawable colorDrawable =(ColorDrawable) rl_header.getBackground();
        int manau = colorDrawable.getColor();
        Intent i4 = new Intent(MainActivity.this, LyThuyetActivity.class);
        i4.putExtra("KEY",manau);
        startActivity(i4);
    }
    private void startTimKiem(){
        ColorDrawable colorDrawable =(ColorDrawable) rl_header.getBackground();
        int manau = colorDrawable.getColor();
        Intent i5 = new Intent(MainActivity.this, MenuTimKiemActivity.class);
        i5.putExtra("KEY",manau);
        startActivity(i5);
    }

    private void showMenu(){
        PopupMenu popupMenu = new PopupMenu(this,img_setting);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu_doiBen:
                        img_setting2.setVisibility(View.VISIBLE);
                        img_setting.setVisibility(View.GONE);
                        SharedPreferences.Editor editor4 = sharedPreferences.edit();
                        editor4.putInt("chon",2);
                        editor4.commit();
                        break;
                    case R.id.menu_mauDo:
                        rl_header.setBackgroundColor(Color.RED);
                        img_lythuyet.setBackgroundColor(Color.RED);
                        btnLyThuyet.setBackgroundColor(Color.RED);
                        btn_lythuyet2.setBackgroundColor(Color.RED);

                        img_video.setBackgroundColor(Color.RED);
                        btn_listVideo2.setBackgroundColor(Color.RED);
                        btnListVideo.setBackgroundColor(Color.RED);

                        btn_hoiDapNhanh.setBackgroundColor(Color.RED);
                        img_hoiDapNhanh.setBackgroundColor(Color.RED);
                        btn_hoidapnhanh2.setBackgroundColor(Color.RED);

                        btn_bienBao.setBackgroundColor(Color.RED);
                        btn_BienBao2.setBackgroundColor(Color.RED);
                        img_BienBao.setBackgroundColor(Color.RED);

                        btn_traCuuLuat.setBackgroundColor(Color.RED);
                        btn_traCuuLuat2.setBackgroundColor(Color.RED);
                        img_traCuuLuat.setBackgroundColor(Color.RED);

                        btn_timKiem.setBackgroundColor(Color.RED);
                        btn_timKiem2.setBackgroundColor(Color.RED);
                        img_timKiem.setBackgroundColor(Color.RED);

                        ColorDrawable colorDrawable =(ColorDrawable) rl_header.getBackground();
                        int manau1 = colorDrawable.getColor();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("mamau1",manau1);
                        editor.commit();

                        break;
                    case R.id.menu_mauVang:
                        rl_header.setBackgroundColor(Color.BLUE);

                        img_lythuyet.setBackgroundColor(Color.BLUE);
                        btnLyThuyet.setBackgroundColor(Color.BLUE);
                        btn_lythuyet2.setBackgroundColor(Color.BLUE);

                        img_video.setBackgroundColor(Color.BLUE);
                        btn_listVideo2.setBackgroundColor(Color.BLUE);
                        btnListVideo.setBackgroundColor(Color.BLUE);

                        btn_hoiDapNhanh.setBackgroundColor(Color.BLUE);
                        img_hoiDapNhanh.setBackgroundColor(Color.BLUE);
                        btn_hoidapnhanh2.setBackgroundColor(Color.BLUE);

                        btn_bienBao.setBackgroundColor(Color.BLUE);
                        btn_BienBao2.setBackgroundColor(Color.BLUE);
                        img_BienBao.setBackgroundColor(Color.BLUE);

                        btn_traCuuLuat.setBackgroundColor(Color.BLUE);
                        btn_traCuuLuat2.setBackgroundColor(Color.BLUE);
                        img_traCuuLuat.setBackgroundColor(Color.BLUE);

                        btn_timKiem.setBackgroundColor(Color.BLUE);
                        btn_timKiem2.setBackgroundColor(Color.BLUE);
                        img_timKiem.setBackgroundColor(Color.BLUE);


                        ColorDrawable colorDrawable2 =(ColorDrawable) rl_header.getBackground();
                        int manau2 = colorDrawable2.getColor();
                        SharedPreferences.Editor editor2 = sharedPreferences.edit();
                        editor2.putInt("mamau1",manau2);
                        editor2.commit();

                        break;
                    case R.id.menu_mauXanh:
                        rl_header.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        img_lythuyet.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btnLyThuyet.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_lythuyet2.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        img_video.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_listVideo2.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btnListVideo.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        btn_hoiDapNhanh.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        img_hoiDapNhanh.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_hoidapnhanh2.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        btn_bienBao.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_BienBao2.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        img_BienBao.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        btn_traCuuLuat.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_traCuuLuat2.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        img_traCuuLuat.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        btn_timKiem.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_timKiem2.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        img_timKiem.setBackgroundColor(getResources().getColor(R.color.xanh1));


                        ColorDrawable colorDrawable3 =(ColorDrawable) rl_header.getBackground();
                        int manau3 = colorDrawable3.getColor();
                        SharedPreferences.Editor editor3 = sharedPreferences.edit();
                        editor3.putInt("mamau1",manau3);
                        editor3.putInt("chon",2);
                        editor3.commit();

                        break;

                }

                return false;
            }
        });
        popupMenu.show();
    }

    private void showMenu1(){
        PopupMenu popupMenu = new PopupMenu(this,img_setting2);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu_doiBen:
                        img_setting2.setVisibility(View.GONE);
                        img_setting.setVisibility(View.VISIBLE);
                        SharedPreferences.Editor editor5 = sharedPreferences.edit();
                        editor5.putInt("chon",1);
                        editor5.commit();
                        break;
                    case R.id.menu_mauDo:
                        rl_header.setBackgroundColor(Color.RED);
                        img_lythuyet.setBackgroundColor(Color.RED);
                        btnLyThuyet.setBackgroundColor(Color.RED);
                        btn_lythuyet2.setBackgroundColor(Color.RED);

                        img_video.setBackgroundColor(Color.RED);
                        btn_listVideo2.setBackgroundColor(Color.RED);
                        btnListVideo.setBackgroundColor(Color.RED);

                        btn_hoiDapNhanh.setBackgroundColor(Color.RED);
                        img_hoiDapNhanh.setBackgroundColor(Color.RED);
                        btn_hoidapnhanh2.setBackgroundColor(Color.RED);

                        btn_bienBao.setBackgroundColor(Color.RED);
                        btn_BienBao2.setBackgroundColor(Color.RED);
                        img_BienBao.setBackgroundColor(Color.RED);

                        btn_traCuuLuat.setBackgroundColor(Color.RED);
                        btn_traCuuLuat2.setBackgroundColor(Color.RED);
                        img_traCuuLuat.setBackgroundColor(Color.RED);

                        btn_timKiem.setBackgroundColor(Color.RED);
                        btn_timKiem2.setBackgroundColor(Color.RED);
                        img_timKiem.setBackgroundColor(Color.RED);

                        ColorDrawable colorDrawable =(ColorDrawable) rl_header.getBackground();
                        int manau1 = colorDrawable.getColor();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("mamau1",manau1);
                        editor.commit();

                        break;
                    case R.id.menu_mauVang:
                        rl_header.setBackgroundColor(Color.BLUE);

                        img_lythuyet.setBackgroundColor(Color.BLUE);
                        btnLyThuyet.setBackgroundColor(Color.BLUE);
                        btn_lythuyet2.setBackgroundColor(Color.BLUE);

                        img_video.setBackgroundColor(Color.BLUE);
                        btn_listVideo2.setBackgroundColor(Color.BLUE);
                        btnListVideo.setBackgroundColor(Color.BLUE);

                        btn_hoiDapNhanh.setBackgroundColor(Color.BLUE);
                        img_hoiDapNhanh.setBackgroundColor(Color.BLUE);
                        btn_hoidapnhanh2.setBackgroundColor(Color.BLUE);

                        btn_bienBao.setBackgroundColor(Color.BLUE);
                        btn_BienBao2.setBackgroundColor(Color.BLUE);
                        img_BienBao.setBackgroundColor(Color.BLUE);

                        btn_traCuuLuat.setBackgroundColor(Color.BLUE);
                        btn_traCuuLuat2.setBackgroundColor(Color.BLUE);
                        img_traCuuLuat.setBackgroundColor(Color.BLUE);

                        btn_timKiem.setBackgroundColor(Color.BLUE);
                        btn_timKiem2.setBackgroundColor(Color.BLUE);
                        img_timKiem.setBackgroundColor(Color.BLUE);


                        ColorDrawable colorDrawable2 =(ColorDrawable) rl_header.getBackground();
                        int manau2 = colorDrawable2.getColor();
                        SharedPreferences.Editor editor2 = sharedPreferences.edit();
                        editor2.putInt("mamau1",manau2);
                        editor2.commit();

                        break;
                    case R.id.menu_mauXanh:
                        rl_header.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        img_lythuyet.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btnLyThuyet.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_lythuyet2.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        img_video.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_listVideo2.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btnListVideo.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        btn_hoiDapNhanh.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        img_hoiDapNhanh.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_hoidapnhanh2.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        btn_bienBao.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_BienBao2.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        img_BienBao.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        btn_traCuuLuat.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_traCuuLuat2.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        img_traCuuLuat.setBackgroundColor(getResources().getColor(R.color.xanh1));

                        btn_timKiem.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        btn_timKiem2.setBackgroundColor(getResources().getColor(R.color.xanh1));
                        img_timKiem.setBackgroundColor(getResources().getColor(R.color.xanh1));


                        ColorDrawable colorDrawable3 =(ColorDrawable) rl_header.getBackground();
                        int manau3 = colorDrawable3.getColor();
                        SharedPreferences.Editor editor3 = sharedPreferences.edit();
                        editor3.putInt("mamau1",manau3);
                        editor3.commit();

                        break;

                }

                return false;
            }
        });
        popupMenu.show();
    }


}
