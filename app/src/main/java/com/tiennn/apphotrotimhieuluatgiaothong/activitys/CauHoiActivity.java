package com.tiennn.apphotrotimhieuluatgiaothong.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tiennn.apphotrotimhieuluatgiaothong.models.CauHoi;
import com.tiennn.apphotrotimhieuluatgiaothong.adapters.CauHoiAdapter;
import com.tiennn.apphotrotimhieuluatgiaothong.common.QuanLyDataCauHoi;
import com.tiennn.apphotrotimhieuluatgiaothong.R;

import java.util.List;

public class CauHoiActivity extends AppCompatActivity {
    private static final String TAG = "CauHoiActivity";

    CauHoiAdapter mAdapter;
    List<CauHoi> mList;
    RadioButton btn_text1,btn_text2,btn_text3;
    RadioGroup btn_radiogroup;


    private ImageView imgReturn;
    private LinearLayout ll_cauhoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau_hoi);
        init();

        Intent i = getIntent();
        int value = i.getIntExtra("KEY",getResources().getColor(R.color.xanh1));
        ll_cauhoi.setBackgroundColor(value);
    }

    private void init() {
        ll_cauhoi = findViewById(R.id.ll_cauhoi);

        // Vào CSDL load dữ liệu
        QuanLyDataCauHoi quanLy = new QuanLyDataCauHoi(this);
        mList = quanLy.read();
        mAdapter = new CauHoiAdapter(this, R.layout.item_cauhoi, mList);
        // mAdapter.notifyDataSetChanged();
        ListView lstViewCauHoi = (ListView) findViewById(R.id.lvcauhoi);
        lstViewCauHoi.setAdapter(mAdapter);


        btn_radiogroup = findViewById(R.id.btn_ridiogroup);
        btn_text1 = findViewById(R.id.btn_text1);
        btn_text2 = findViewById(R.id.btn_text2);
        btn_text3 = findViewById(R.id.btn_text3);

        imgReturn = findViewById(R.id.imgReturn);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CauHoiActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        lstViewCauHoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String a = mList.get(position).getDapan();
                Toast.makeText(CauHoiActivity.this,"click",Toast.LENGTH_SHORT).show();
            }
        });



        //for (int i = 0 ; i < mList.size();i++){
        //    if (mList.get(i).getDapan() == 1){
        //        Toast.makeText(CauHoiActivity.this, "Đúng",
        //                Toast.LENGTH_SHORT).show();
        //    }else {
        //        Toast.makeText(CauHoiActivity.this, "Sai",
        //                Toast.LENGTH_SHORT).show();
         //   }
      //  }
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }




}