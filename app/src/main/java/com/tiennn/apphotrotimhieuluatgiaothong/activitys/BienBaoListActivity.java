package com.tiennn.apphotrotimhieuluatgiaothong.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tiennn.apphotrotimhieuluatgiaothong.models.BienBao;
import com.tiennn.apphotrotimhieuluatgiaothong.adapters.BienBaoAdapter;
import com.tiennn.apphotrotimhieuluatgiaothong.R;

import java.util.ArrayList;

public class BienBaoListActivity extends AppCompatActivity {
    private ImageView imgReturn;
    private ListView lvBienbao;
    private LinearLayout ll_bienbao;
    private ArrayList<BienBao> bienBaos;
    BienBaoAdapter bienBaoAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienbao);

        imgReturn = findViewById(R.id.imgReturn);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BienBaoListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        lvBienbao = findViewById(R.id.lvBienbao);
        ll_bienbao = findViewById(R.id.ll_bienbao);

        Intent i1 = getIntent();
        int value = i1.getIntExtra("KEY",getResources().getColor(R.color.xanh1));
        ll_bienbao.setBackgroundColor(value);

        bienBaos = new ArrayList<>();

        bienBaos.add(new BienBao(R.drawable.camdinguocchieu,"Cấm đi ngược chiều","Cấm tất cả các loại xe đi theo chiều đặt biển."));
        bienBaos.add(new BienBao(R.drawable.camdi2chieu,"Cấm đỗ xe ngày chẵn ","Cấm tất cả các loại xe đỗ xe vào các ngày chẵn.Trừ các xe được ưu tiên theo quy định."));
        bienBaos.add(new BienBao(R.drawable.camdungdoxe,"Cấm dừng xe và đỗ xe","Cấm tất cả các loại xe dừng và đỗ xe"));
        bienBaos.add(new BienBao(R.drawable.cambamcoi,"Cấm bấm còi xe","Khu vực đông dân cư . Cấm bấm còi xe gây tiếng ồn."));
        bienBaos.add(new BienBao(R.drawable.camrephai,"Cấm rẽ phải","Cấm rẽ phải (theo hướng mũi tên trên biển báo)"));
        bienBaos.add(new BienBao(R.drawable.camquaydau,"Cấm quay xe","Cấm quay đầu theo hình chữ U ,trừ các xe ưu tiên."));
        bienBaos.add(new BienBao(R.drawable.camxemoto,"Cấm xe mô tô","Đường cấm tất cả các loại xe mô tô đi qua."));
        bienBaos.add(new BienBao(R.drawable.camxetai,"Cấm xe tải","Cấm các loại xe tải đi qua đoạn đường này"));
        bienBaos.add(new BienBao(R.drawable.camxetren10tan,"Hạn chế trọng lượng xe","Cấm các loại xe cơ giới,sô sơ có trọng lượng trên 10 tấn"));
        bienBaos.add(new BienBao(R.drawable.conhieungare,"Có nhiều ngã rẽ","Chuẩn bị giao nhau với ngã tư"));
        bienBaos.add(new BienBao(R.drawable.dunglai,"Dừng lại","Tất cả các phương tiện dừng lại"));
        bienBaos.add(new BienBao(R.drawable.camdithang,"Cấm đi thẳng, rẽ trái","Cấm tất cả các phương tiện đi thẳng và rẽ trái"));
        bienBaos.add(new BienBao(R.drawable.camnguoidibo,"Cấm người đi bộ","Đoạn đường cấm người đi bộ qua đường"));
        bienBaos.add(new BienBao(R.drawable.dangthicong,"Đang thi công","Đoạn đường đang được thi công"));
        bienBaos.add(new BienBao(R.drawable.dicham,"Đi chậm","Đoạn đường cần chú ý quan sát và đi chậm"));
        bienBaos.add(new BienBao(R.drawable.doc10do,"Dốc xuống nguy hiểm","Đoạn đường sắp tới có chỗ dốc nguy hiểm"));
        bienBaos.add(new BienBao(R.drawable.nguoigiasangduong,"Biển báo qua đường trước Viện Lão khoa trung ương ","Biển báo qua đường trước Viện Lão khoa trung ương . Người già thường xuyên qua đường"));
        bienBaos.add(new BienBao(R.drawable.nguyhiem,"Nguy Hiểm","Đoạn đường nguy hiểm"));
        bienBaos.add(new BienBao(R.drawable.landuonguutien,"Đường ưu tiên","Chuẩn bị giao nhau với đường ưu tiên"));
        bienBaos.add(new BienBao(R.drawable.duongtauhoa,"Giao nhau với đường tàu hỏa","Giao nhau với đường tàu hỏa . Các phương tiện chú ý quan sát"));
        bienBaos.add(new BienBao(R.drawable.codongvat,"Thú rừng vượt qua đường","Gần tới đoạn có thú rừng qua đường "));


        bienBaoAdapter = new BienBaoAdapter(this,R.layout.item_bienbao,bienBaos);
        lvBienbao.setAdapter(bienBaoAdapter);



    }
}
