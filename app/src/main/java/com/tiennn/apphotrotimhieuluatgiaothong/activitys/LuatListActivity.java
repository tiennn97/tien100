package com.tiennn.apphotrotimhieuluatgiaothong.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.tiennn.apphotrotimhieuluatgiaothong.models.Luat;
import com.tiennn.apphotrotimhieuluatgiaothong.adapters.LuatAdapter;
import com.tiennn.apphotrotimhieuluatgiaothong.common.QuanLyDataLuat;
import com.tiennn.apphotrotimhieuluatgiaothong.R;

import java.util.List;

public class LuatListActivity extends AppCompatActivity {
    LuatAdapter mAdapter;
    List<Luat> mList;

    private ImageView imgReturn;
    private LinearLayout ll_traCuuLuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracuuluat);
        init();

        Intent i = getIntent();
        int value = i.getIntExtra("KEY",getResources().getColor(R.color.xanh1));
        ll_traCuuLuat.setBackgroundColor(value);
    }

    private void init() {
        ll_traCuuLuat = findViewById(R.id.ll_traCuuLuat);

        // Vào CSDL load dữ liệu
        QuanLyDataLuat quanLy = new QuanLyDataLuat(this);
        mList = quanLy.read();
        mAdapter = new LuatAdapter(this, R.layout.item_tracuuluat, mList);
        // mAdapter.notifyDataSetChanged();
        ListView lstViewLuat = (ListView) findViewById(R.id.lvTracuuluat);
        lstViewLuat.setAdapter(mAdapter);

        imgReturn = findViewById(R.id.imgReturn);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LuatListActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

}
