package com.tiennn.apphotrotimhieuluatgiaothong.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tiennn.apphotrotimhieuluatgiaothong.models.Luat;
import com.tiennn.apphotrotimhieuluatgiaothong.R;
import com.tiennn.apphotrotimhieuluatgiaothong.models.VideoYouTube;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LuatAdapter extends ArrayAdapter<Luat> {

    Context mCtx;
    int mResLayout;
    List<Luat> mLst;
    private ArrayList<Luat> arrayList;


    public LuatAdapter(Context context, int resource, List<Luat> objects) {
        super(context, resource, objects);

        this.mCtx = context;
        this.mResLayout = resource;
        this.mLst = objects;

        this.arrayList = new ArrayList<Luat>();
        this.arrayList.addAll(mLst);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(mCtx).inflate(mResLayout, null);
        }

        Luat l = mLst.get(position);

        ((TextView) row.findViewById(R.id.txtText2)).setText(l.getText2());
        ((TextView) row.findViewById(R.id.txtText3)).setText(l.getText3());

        return row;
    }

    public void filer(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        mLst.clear();

        for (Luat luat: arrayList
        ) {
            if (luat.getText2().toLowerCase(Locale.getDefault()).contains(charText)){
                mLst.add(luat);
            }
        }
        notifyDataSetChanged();
    }
}

