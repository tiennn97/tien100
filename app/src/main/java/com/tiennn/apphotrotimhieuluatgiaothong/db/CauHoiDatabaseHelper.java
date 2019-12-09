package com.tiennn.apphotrotimhieuluatgiaothong.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CauHoiDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME1  ="cauhoi.sqlite";
    private static final int DATABASE_VERSION1 = 1;

    public CauHoiDatabaseHelper(Context context) {
        super(context, DATABASE_NAME1, null, DATABASE_VERSION1);
    }

    @Override
    public void onCreate(SQLiteDatabase db1) {
        String sql1 = "CREATE TABLE cauhoi (\n" +
                "    id     INT (128)     PRIMARY KEY,\n" +
                "    cauhoi VARCHAR (128) UNIQUE\n" +
                "                         NOT NULL,\n" +
                "    dapan1 VARCHAR (128) NOT NULL,\n" +
                "    dapan2 VARCHAR (128) NOT NULL,\n" +
                "    dapan3 VARCHAR (128) NOT NULL,\n" +
                "    dapan  VARCHAR (8)       NOT NULL\n" +
                ");\n";
        db1.execSQL(sql1);

        sql1 = "INSERT INTO cauhoi (cauhoi,dapan1,dapan2,dapan3,dapan) VALUES ('Khái niệm \"đường bộ\" được hiểu như thế nào là đúng? Đường bộ gồm:','Đường bộ, cầu đường bộ.','Hầm đường bộ, bến phà đường bộ.','Đường, cầu đường bộ, hầm đường bộ, bến phà đường bộ và các công trình phụ trợ khác.','A')";
        db1.execSQL(sql1);
        sql1 = "INSERT INTO cauhoi (cauhoi,dapan1,dapan2,dapan3,dapan) VALUES ('\"Phương tiện giao thông đường bộ\" gồm những loại nào?','Phương tiện giao thông cơ giới đường bộ, phương tiện giao thông thô sơ đường bộ.','Phương tiện giao thông thô sơ đường bộ, phương tiện giao thông cơ giới đường bộ và xe máy chuyên dùng.','Cả hai ý nêu trên.','B')";
        db1.execSQL(sql1);
        sql1 = "INSERT INTO cauhoi (cauhoi,dapan1,dapan2,dapan3,dapan) VALUES ('Người điều khiển xe ô tô, xe máy kéo, xe máy chuyên dùng trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt quá bao nhiêu thì bị cấm?','Người điều khiển xe ô tô, máy kéo, xe máy chuyên dùng trên đường mà trong máu có nồng độ cồn vượt quá 50 miligam/100 mililit máu hoặc 0,25 miligam/1 lít khí thở.','Người điều khiển xe ô tô, máy kéo, xe máy chuyên dùng trên đường mà trong máu hoặc hơi thở có nồng độ cồn.','Người điều khiển xe ô tô, máy kéo, xe máy chuyên dùng trên đường mà trong máu có nồng độ cồn vượt quá 80 miligam/100 mililít máu hoặc 40 miligam/1 lít khí thở.','B')";
        db1.execSQL(sql1);
        sql1 = "INSERT INTO cauhoi (cauhoi,dapan1,dapan2,dapan3,dapan) VALUES ('Tại nơi đường giao nhau có báo hiệu đi theo vòng xuyến người điều khiển phương tiện phải nhường đường như thế nào?','Phải nhường đường cho xe đi bên phải.','Xe báo hiệu xin đường trước xe đo được đi trước.','Phải nhường đường cho xe đi bên trái.','B')";
        db1.execSQL(sql1);
        sql1 = "INSERT INTO cauhoi (cauhoi,dapan1,dapan2,dapan3,dapan) VALUES ('Trên đường bộ trong khu vực đông dân cư, xe mô tô hai bánh, xe gắn máy tham gia giao thông với tốc độ tối đa cho phép là bao nhiêu?\n','60km/h.','50km/h.','40km/h.','B')";
        db1.execSQL(sql1);
        sql1 = "INSERT INTO cauhoi (cauhoi,dapan1,dapan2,dapan3,dapan) VALUES ('Khi xảy ra tai nạn giao thông, những hành vi nào ghi ở dưới đây bị nghiêm cấm?','Xâm phạm tính mạng, sức khỏe, tài sản của người bị tai nạn giao thông; xâm phạm tính mạng, sức khỏe, tài sản của người gây tai nạn giao thông.','Lợi dụng việc xảy ra tai nạn giao thông để hành hung, đe dọa, xúi giục, gây sức ép, làm mất trật tự, cản trở việc xử lý tai nạn giao thông.','Cả hai ý nêu trên.','C')";
        db1.execSQL(sql1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
