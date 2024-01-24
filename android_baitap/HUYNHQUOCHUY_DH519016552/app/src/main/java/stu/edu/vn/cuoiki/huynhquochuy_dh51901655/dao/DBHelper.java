package stu.edu.vn.cuoiki.huynhquochuy_dh51901655.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


import java.util.ArrayList;
import java.util.List;

import stu.edu.vn.cuoiki.huynhquochuy_dh51901655.model.sanpham;


public class DBHelper extends SQLiteOpenHelper {

    public static class TABLE implements BaseColumns {
        public static final String TABLE_NAME = "SANPHAM";
        public static final String COLUMN_M = "MA";
        public static final String COLUMN_Ten = "TEN";
        public static final String COLUMN_Gia = "GIA";
        public static final String COLUMN_Nambaohanh = "NAMBAOHANH";
    }
    private static final String DB_Name = "qlsanpham.sqlite";
    private static final int DB_Version = 1;

    public static final String SQL_Create_Table = "CREATE TABLE IF NOT EXISTS "
            + TABLE.TABLE_NAME + " (" + TABLE.COLUMN_M + " VARCHAR(10) PRIMARY KEY , "
            + TABLE.COLUMN_Ten + " VARCHAR(50), "
            + TABLE.COLUMN_Gia + " FLOAT,"
            + TABLE.COLUMN_Nambaohanh + " INTEGER)";

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


    public List<sanpham> getAllsanpham() {
        List<sanpham> listsanpham = new ArrayList<>();

        String[] projection = {
                TABLE.COLUMN_M,
                TABLE.COLUMN_Ten,
                TABLE.COLUMN_Gia,
                TABLE.COLUMN_Nambaohanh
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
            sanpham sanpham = new sanpham();
            sanpham.setMasp(cursor.getString(cursor.getColumnIndexOrThrow(TABLE.COLUMN_M)));
            sanpham.setTensp(cursor.getString(cursor.getColumnIndexOrThrow(TABLE.COLUMN_Ten)));
            sanpham.setGia(cursor.getFloat(cursor.getColumnIndexOrThrow(TABLE.COLUMN_Gia)));
            sanpham.setNam(cursor.getInt(cursor.getColumnIndexOrThrow(TABLE.COLUMN_Nambaohanh)));
            listsanpham.add(sanpham);
        }

        cursor.close();
        return listsanpham;
    }

    public void insertsanpham(sanpham sanpham) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TABLE.COLUMN_M, sanpham.getMasp());
        values.put(TABLE.COLUMN_Ten, sanpham.getTensp());
        values.put(TABLE.COLUMN_Gia, sanpham.getGia());
        values.put(TABLE.COLUMN_Nambaohanh, sanpham.getNam());

        long newRow = db.insert(TABLE.TABLE_NAME, null, values);
        String msg="";
        if(newRow == -1){
            msg="them that bai";
        }else{
            msg="them thanh cong";
        }

    }

    public void deletesanpham(String Ma)
    {
        String selection = TABLE.COLUMN_M + " = ?";
        String[] selectionArgs ={Ma};
        int deleteRows =getWritableDatabase().delete(TABLE.TABLE_NAME, selection, selectionArgs);
    }

    public void updatesanpham(sanpham sanpham)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TABLE.COLUMN_Ten, sanpham.getTensp());
        values.put(TABLE.COLUMN_Gia, sanpham.getGia());
        values.put(TABLE.COLUMN_Nambaohanh, sanpham.getNam());
        String selection = TABLE.COLUMN_M + " =?";
        String[] selectionArgs = {sanpham.getMasp()+""};
        int updateRows=db.update(TABLE.TABLE_NAME, values,selection,selectionArgs);

        String msg="";
        if(updateRows == 0){
            msg="sua that bai";
        }else{
            msg="sua thanh cong";
        }

    }
    public void QueryData(String sql)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
}
