package com.tiennn.apphotrotimhieuluatgiaothong.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME  ="luat.sqlite";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE luat (\n" +
                "    id    INT (128)     PRIMARY KEY,\n" +
                "    text2 VARCHAR (128) NOT NULL\n" +
                "                        UNIQUE,\n" +
                "    text3 VARCHAR (128) NOT NULL\n" +
                ");";
        db.execSQL(sql);

        sql = "INSERT INTO luat (text2,text3) VALUES ('Không chú ý quan sát,điều khiển xe chạy quá tốc độ quy định gây tai nạn giao thông', 'MỨC PHẠT:2.000.000 - 3.000.000 VÀ TƯỚC QUYỀN SỬ DỤNG GIẤY PHÉP LÁI XE 02 THÁNG')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Không giảm tốc độ hoặc không nhường đường khi điều khiển xe chạy trong ngõ, đường nhánh ra đường chính', 'MỨC PHẠT:100.000 - 200.000')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Điều khiển xe chạy tốc độ thấp mà không đi bên phải phần đường xe chạy gây cẩn trở giao thông', 'MỨC PHẠT:100.000 - 200.000')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Điều khiển xe chạy quá tốc độ quy định từ 05 km/h đến dưới 10 km/h', 'MỨC PHẠT:100.000 - 200.000')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Điều khiển xe chạy dưới tốc độ tối thiểu trên những đoạn đường bộ có quy định tốc độ tối thiểu cho phép', 'MỨC PHẠT:200.000 - 400.000')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Điều khiển xe chạy quá tốc độ quy định từ 10km/h đến 20km/h', 'MỨC PHẠT:500.000 - 1.000.000')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Điều khiển xe chạy quá tốc độ quy định từ 20km/h trở lên', 'MỨC PHẠT:2.000.000 - 3.000.000 VÀ TƯỚC QUYỀN SỬ DỤNG GIẤY PHÉP LÁI XE 01 THÁNG')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Đua xe mô tô ,xe gắn máy , xe đạp điện trái phép', '\"MỨC PHẠT:1.000.000 - 2.000.000 VÀ TƯỚC QUYỀN SỬ DỤNG GIẤY PHÉP LÁI XE 04 THÁNG')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Điều khiển xe trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt quá 50 miligam đến 80 miligam/100 millit máu', 'MỨC PHẠT:1.000.000 - 2.000.000 VÀ TƯỚC QUYỀN SỬ DỤNG GIẤY PHÉP LÁI XE 01 THÁNG')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Xe không có còi , đèn soi biển số , đền báo hãm ,gương chiếu hậu bên trái', 'MỨC PHẠT:80.000 - 100.000')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Xe gắn biển số không đúng theo quy định , biển số không rõ chữ số , biển số bị bẻ cong, bị che lấp , bi hỏng', 'MỨC PHẠT:80.000 - 100.000')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Xe không có đèn tín hiệu hoặc có nhưng không có tác dụng', 'MỨC PHẠT:80.000 - 100.000')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Sử dụng còi không đúng quy định chuẩn kỹ thuật cho từng loại xe', 'MỨC PHẠT:100.000 - 200.000')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Điều khiển xe không có bộ phận giảm thanh , giảm khỏi hoặc có nhưng không đảm bảo quy chuẩn môi trường về khí thải tiếng ồn', 'MỨC PHẠT:100.000 - 200.000')";
        db.execSQL(sql);
        sql = "INSERT INTO luat (text2,text3) VALUES ('Điều khiển xe không có đèn chiếu sáng gần xa hoặc có nhưng không có tác dụng , không đúng tiêu chuẩn thiết kế.', 'MỨC PHẠT:100.000 - 200.000')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
