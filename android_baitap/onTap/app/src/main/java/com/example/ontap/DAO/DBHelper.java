package com.example.ontap.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.ontap.Model.baihat;


public class DBHelper extends SQLiteOpenHelper {
    public static class TABLE implements BaseColumns {
        public static final String TABLE_NAME = "BAIHAT";
        public static final String COLUMN_Ma = "MA";
        public static final String COLUMN_Ten = "TEN";
        public static final String COLUMN_TacGia = "TACGIA";
        public static final String COLUMN_ThoiLuong = "THOILUONG";
    }

    private final static String DB_Name="BAIHAT.sqlite";
    private static final int DB_Version = 1;

    public static final String SQL_Create_Table = "CREATE TABLE IF NOT EXISTS " + TABLE.TABLE_NAME + " (" + TABLE.COLUMN_Ma + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TABLE.COLUMN_Ten + " VARCHAR(50), " + TABLE.COLUMN_TacGia + " VARCHAR(50), " + TABLE.COLUMN_ThoiLuong+ " Integer" ;
    /*public  static  final String Drop_table = "DROP TABLE IF EXISTS " + TABLE.TABLE_NAME;*/
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



    public List<baihat> getgetAllSV() {
        List<baihat> ListSV = new ArrayList<>();

        String[] projection = {
                TABLE.COLUMN_Ma,
                TABLE.COLUMN_Ten,
                TABLE.COLUMN_TacGia,
                TABLE.COLUMN_ThoiLuong
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
            baihat baihat = new baihat();
            baihat.setMa(String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(TABLE.COLUMN_Ma))));
            baihat.setTen(cursor.getString(cursor.getColumnIndexOrThrow(TABLE.COLUMN_Ten)));
            baihat.setTacgia(cursor.getString(cursor.getColumnIndexOrThrow(TABLE.COLUMN_TacGia)));
            baihat.setThoiluong(cursor.getInt(cursor.getColumnIndexOrThrow(TABLE.COLUMN_ThoiLuong)));
//            String gioiTinhString = cursor.getString(cursor.getColumnIndexOrThrow(TABLE.COLUMN_GioiTinh));
//            boolean gioiTinh = gioiTinhString.equals("1"); // hoặc sử dụng Integer.parseInt(gioiTinhString) == 1
//            sinhVien.setGioiTinh(gioiTinh);
            ListSV.add(baihat);
        }
        cursor.close();
        return ListSV;
    }
//    public SinhVien findSinhVien(int ma){
//        SQLiteDatabase db = this.getReadableDatabase();
//        String[] projection = {
//                DBHelper.COLUMN_Ma,
//                DBHelper.COLUMN_Ten,
//                DBHelper.COLUMN_GioiTinh
//        };
//        String selection = COLUMN_Ma + " = ?";
//        String[] selectionArg = {String.valueOf(ma)};
//        Cursor cursor = getReadableDatabase().query(
//                DBHelper.TABLE_NAME,
//                projection,
//                null,
//                null,
//                null,
//                null,
//                null
//        );
//        SinhVien sv= new SinhVien();
//        if(cursor != null && cursor.moveToFirst()){
//            sv.setMa(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_Ma)));
//            sv.setTen(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_Ten)));
//            String gioiTinhString = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_GioiTinh));
//            boolean gioiTinh = gioiTinhString.equals("1"); // hoặc sử dụng Integer.parseInt(gioiTinhString) == 1
//            sv.setGioiTinh(gioiTinh);
//            cursor.close();
//        }
//        return sv;
//    }
public void insertSinhVien(baihat bh) {
    if (isSinhVienExist(Integer.parseInt(bh.getMa()))) {
        Log.e("DBHelper", "insertSinhVien: SinhVien already exists");
        return;
    }
    SQLiteDatabase db = getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(TABLE.COLUMN_Ma, bh.getMa());
    values.put(TABLE.COLUMN_Ten, bh.getTen());
    values.put(TABLE.COLUMN_TacGia, bh.getTacgia());
    values.put(TABLE.COLUMN_ThoiLuong, bh.getThoiluong());
    long result = db.insert(TABLE.TABLE_NAME, null, values);
    db.close();

    if (result != -1) {
        Log.d("DBHelper", "insertSinhVien: Insert successful");
    } else {
        Log.e("DBHelper", "insertSinhVien: Insert failed");
    }
}


    public void deleteSinhVien(Integer Ma)
    {
        SQLiteDatabase db = getWritableDatabase();
        String selection = TABLE.COLUMN_Ma + " = ?";
        String[] selectionArgs ={String.valueOf(Ma)};
        db.delete(TABLE.TABLE_NAME, selection, selectionArgs);
        db.close();
    }
    public void updateSinhVien(baihat bh) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE.COLUMN_Ten, bh.getTen());
        values.put(TABLE.COLUMN_TacGia, bh.getTacgia());
        values.put(TABLE.COLUMN_ThoiLuong, bh.getThoiluong());

        String selection = TABLE.COLUMN_Ma + " = ?";
        String[] selectionArgs = {String.valueOf(bh.getMa())};

        int updateRows = db.update(TABLE.TABLE_NAME, values, selection, selectionArgs);
        db.close();

        if (updateRows > 0) {
            Log.d("DBHelper", "updateSinhVien: Update successful");
        } else {
            Log.e("DBHelper", "updateSinhVien: Update failed");
        }
    }
//    public void updateSinhVien(baihat bh)
//    {
//        ContentValues values = new ContentValues();
//        SQLiteDatabase db = getWritableDatabase();
//        values.put(TABLE.COLUMN_Ma, bh.getMa());
//        values.put(TABLE.COLUMN_Ten, bh.getTen());
//        values.put(TABLE.COLUMN_TacGia, bh.getTacgia());
//        values.put(TABLE.COLUMN_ThoiLuong, bh.getThoiluong());
//        int updateRows=db.update(TABLE.TABLE_NAME,null,context,values);
////        values.put(TABLE.COLUMN_Ten, sinhVien.getTen());
////        values.put(TABLE.COLUMN_GioiTinh, sinhVien.isGioiTinh());
////        String selection = TABLE.COLUMN_Ma + " =?";
////        String[] selectionArgs = {sinhVien.getMa()+""};
////        db.update(TABLE.TABLE_NAME, values, selection, selectionArgs);
////        db.close();
//    }
    private boolean isSinhVienExist(int ma) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                TABLE.TABLE_NAME,
                new String[]{TABLE.COLUMN_Ma},
                TABLE.COLUMN_Ma + "=?",
                new String[]{String.valueOf(ma)},
                null,
                null,
                null
        );

        boolean exist = cursor != null && cursor.getCount() > 0;
        if (cursor != null) {
            cursor.close();
        }
        return exist;
    }

    public void QueryData(String sql)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
}
