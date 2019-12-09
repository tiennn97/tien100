package com.tiennn.apphotrotimhieuluatgiaothong.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tiennn.apphotrotimhieuluatgiaothong.models.CauHoi;
import com.tiennn.apphotrotimhieuluatgiaothong.R;

import java.util.List;

public class CauHoiAdapter extends ArrayAdapter<CauHoi> {

    Context mCtx1;
    int mResLayout1;
    List<CauHoi> mLst1;


    public CauHoiAdapter(Context context, int resource, List<CauHoi> objects) {
        super(context, resource, objects);

        this.mCtx1 = context;
        this.mResLayout1 = resource;
        this.mLst1 = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(mCtx1).inflate(mResLayout1, null);
        }

        CauHoi ch = mLst1.get(position);

        ((TextView) row.findViewById(R.id.btn_text0)).setText(ch.getCauhoi());
        ((TextView) row.findViewById(R.id.btn_text1)).setText(ch.getDapan1());
        ((TextView) row.findViewById(R.id.btn_text2)).setText(ch.getDapan2());
        ((TextView) row.findViewById(R.id.btn_text3)).setText(ch.getDapan3());

        return row;
    }
}

