package com.tiennn.apphotrotimhieuluatgiaothong.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import com.tiennn.apphotrotimhieuluatgiaothong.R;
import com.tiennn.apphotrotimhieuluatgiaothong.adapters.LuatAdapter;
import com.tiennn.apphotrotimhieuluatgiaothong.common.QuanLyDataLuat;
import com.tiennn.apphotrotimhieuluatgiaothong.models.Luat;
import com.tiennn.apphotrotimhieuluatgiaothong.models.VideoYouTube;

import java.util.ArrayList;

public class TimKiemLuatActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    LuatAdapter mAdapter;
    ArrayList<Luat> mList;

    private ListView lv_timKiemLuat;
    private ImageView imgReturn;
    private SearchView searchViewLuat;
    private LinearLayout ll_timkiemluat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem_luat);

        ll_timkiemluat = findViewById(R.id.ll_timkiemluat);
        Intent i2 = getIntent();
        int value = i2.getIntExtra("KEY1",getResources().getColor(R.color.xanh1));
        ll_timkiemluat.setBackgroundColor(value);

        lv_timKiemLuat = findViewById(R.id.lv_timKiemLuat);

        QuanLyDataLuat quanLy = new QuanLyDataLuat(this);
        mList = quanLy.read();
        mAdapter = new LuatAdapter(this, R.layout.item_tracuuluat, mList);
        // mAdapter.notifyDataSetChanged();
        lv_timKiemLuat = findViewById(R.id.lv_timKiemLuat);
        lv_timKiemLuat.setAdapter(mAdapter);


        searchViewLuat = findViewById(R.id.searchLuat);
        searchViewLuat.setOnQueryTextListener(this);

        imgReturn = findViewById(R.id.imgReturn);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable colorDrawable =(ColorDrawable) ll_timkiemluat.getBackground();
                int manau2 = colorDrawable.getColor();
                Intent i5 = new Intent(TimKiemLuatActivity.this,MenuTimKiemActivity.class);
                i5.putExtra("KEY",manau2);
                startActivity(i5);
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mAdapter.filer(newText.trim());
        return false;
    }
}
