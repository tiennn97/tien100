package com.tiennn.apphotrotimhieuluatgiaothong.common;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tiennn.apphotrotimhieuluatgiaothong.db.CauHoiDatabaseHelper;
import com.tiennn.apphotrotimhieuluatgiaothong.models.CauHoi;

import java.util.ArrayList;

public class QuanLyDataCauHoi {
    Context mContext1;
    SQLiteDatabase mDB1;

    public QuanLyDataCauHoi(Context ctx1) {
        this.mContext1 = ctx1;

        // Mở kết nối tới csdl
        CauHoiDatabaseHelper helper1 = new CauHoiDatabaseHelper(this.mContext1);
        // Lấy đối tượng thao tác với CSDL
        mDB1 = helper1.getWritableDatabase();
    }

    public ArrayList<CauHoi> read() {
        ArrayList<CauHoi> list1 = new ArrayList<>();

        String sql1 = "SELECT * FROM cauhoi";
        Cursor c = mDB1.rawQuery(sql1, null);
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String dapan = c.getString(c.getColumnIndex("dapan"));
            String cauhoi = c.getString(c.getColumnIndex("cauhoi"));
            String dapan1 = c.getString(c.getColumnIndex("dapan1"));
            String dapan2 = c.getString(c.getColumnIndex("dapan2"));
            String dapan3 = c.getString(c.getColumnIndex("dapan3"));

            CauHoi ch = new CauHoi(id, cauhoi, dapan1,dapan2,dapan3,dapan);
            list1.add(ch);
        }

        return list1;
    }

}