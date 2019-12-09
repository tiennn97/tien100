package com.tiennn.apphotrotimhieuluatgiaothong.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiennn.apphotrotimhieuluatgiaothong.R;
import com.tiennn.apphotrotimhieuluatgiaothong.models.BienBao;
import com.tiennn.apphotrotimhieuluatgiaothong.models.TinhHuong;

import java.util.List;

public class TinhHuongAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TinhHuong> tinhHuongs;

    public TinhHuongAdapter(Context context, int layout, List<TinhHuong> tinhHuongs) {
        this.context = context;
        this.layout = layout;
        this.tinhHuongs = tinhHuongs;
    }

    @Override
    public int getCount() {
        return tinhHuongs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        ImageView img_anh = view.findViewById(R.id.img_anh);
        TextView tv_text = view.findViewById(R.id.tv_text);

        TinhHuong tinhHuong = tinhHuongs.get(position);

        tv_text.setText(tinhHuong.getText());
        img_anh.setImageResource(tinhHuong.getAnh());
        return view;
    }
}
