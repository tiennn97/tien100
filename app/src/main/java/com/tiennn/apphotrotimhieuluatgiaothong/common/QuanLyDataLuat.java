package com.tiennn.apphotrotimhieuluatgiaothong.common;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tiennn.apphotrotimhieuluatgiaothong.db.DatabaseHelper;
import com.tiennn.apphotrotimhieuluatgiaothong.models.Luat;

import java.util.ArrayList;

public class QuanLyDataLuat {
    Context mContext;
    SQLiteDatabase mDB;

    public QuanLyDataLuat(Context ctx) {
        this.mContext = ctx;

        // Mở kết nối tới csdl
        DatabaseHelper helper = new DatabaseHelper(this.mContext);
        // Lấy đối tượng thao tác với CSDL
        mDB = helper.getWritableDatabase();
    }

    public ArrayList<Luat> read() {
        ArrayList<Luat> list = new ArrayList<>();

        String sql = "SELECT * FROM luat";
        Cursor c = mDB.rawQuery(sql, null);
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String text2 = c.getString(c.getColumnIndex("text2"));
            String text3 = c.getString(c.getColumnIndex("text3"));

            Luat l = new Luat(id, text2, text3);
            list.add(l);
        }

        return list;
    }

}
