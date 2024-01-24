package com.example.quanlymaytinh.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.widget.Toast;


import com.example.quanlymaytinh.MainActivity;
import com.example.quanlymaytinh.MainActivity2;
import com.example.quanlymaytinh.model.MayTinh;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    public static class TABLE implements BaseColumns {
        public static final String TABLE_NAME = "MAYTINH1";
        public static final String COLUMN_M = "MA";
        public static final String COLUMN_Ten = "TEN";
        public static final String COLUMN_Soluong = "SOLUONG";
        public static final String COLUMN_Giatien = "GIATIEN";
    }
    private static final String DB_Name = "dbmaytinh1.sqlite";
    private static final int DB_Version = 1;

    public static final String SQL_Create_Table = "CREATE TABLE IF NOT EXISTS "
            + TABLE.TABLE_NAME + " ("
            + TABLE.COLUMN_M + " INTEGER PRIMARY KEY, "
            + TABLE.COLUMN_Ten + " VARCHAR(50), "
            + TABLE.COLUMN_Soluong + " INTEGER,"
            + TABLE.COLUMN_Giatien + " FLOAT)";

    public  static  final String Drop_table = "DROP TABLE IF EXISTS " + TABLE.TABLE_NAME;


    public Cursor getData(String sql)
    {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    public boolean a;

    public DBHelper(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    Context context;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldver ,int newver) {

    }


    public List<MayTinh> getAllMaytinh() {
        List<MayTinh> ListMaytinh = new ArrayList<>();

        String[] projection = {
                TABLE.COLUMN_M,
                TABLE.COLUMN_Ten,
                    TABLE.COLUMN_Soluong,
                TABLE.COLUMN_Giatien
        };
        Cursor cursor = getReadableDatabase().query(
                TABLE.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            MayTinh mayTinh = new MayTinh();
            mayTinh.setMaMay(cursor.getInt(cursor.getColumnIndexOrThrow(TABLE.COLUMN_M)));
            mayTinh.setTenMay(cursor.getString(cursor.getColumnIndexOrThrow(TABLE.COLUMN_Ten)));
            mayTinh.setSoLuong(cursor.getInt(cursor.getColumnIndexOrThrow(TABLE.COLUMN_Soluong)));
            mayTinh.setGiaTien(cursor.getFloat(cursor.getColumnIndexOrThrow(TABLE.COLUMN_Giatien)));
            ListMaytinh.add(mayTinh);
        }

        cursor.close();
        return ListMaytinh;
    }

    public void insertMaytinh(MayTinh mayTinh) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TABLE.COLUMN_M, mayTinh.getMaMay());
        values.put(TABLE.COLUMN_Ten, mayTinh.getTenMay());
        values.put(TABLE.COLUMN_Soluong, mayTinh.getSoLuong());
        values.put(TABLE.COLUMN_Giatien, mayTinh.getGiaTien());

        long newRow = db.insert(TABLE.TABLE_NAME, null, values);
    }

    public void deleteMaytinh(String Ma)
    {
        String selection = TABLE.COLUMN_M + " = ?";
        String[] selectionArgs ={Ma};
        int deleteRows =getWritableDatabase().delete(TABLE.TABLE_NAME, selection, selectionArgs);
    }

    public void updateMaytinh(MayTinh mayTinh)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TABLE.COLUMN_Ten, mayTinh.getTenMay());
        values.put(TABLE.COLUMN_Soluong, mayTinh.getSoLuong());
        values.put(TABLE.COLUMN_Giatien, mayTinh.getGiaTien());
        String selection = TABLE.COLUMN_M + " =?";
        String[] selectionArgs = {mayTinh.getMaMay()+""};
        int updateRows=db.update(TABLE.TABLE_NAME, values,selection,selectionArgs);
        String msg ="";
        if(updateRows == 0){
            msg = "khong co bang ghi de cap nhat";
        }else{
            msg = "Cap nhat thanh cong";
        }

    }
    public void QueryData(String sql)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
}
