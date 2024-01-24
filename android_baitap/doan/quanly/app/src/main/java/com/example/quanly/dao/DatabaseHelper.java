package com.example.DoAn.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.DoAn.model.ThongTinBanBe;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "THONGTIN.sqlite";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "TTBanBe";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_IMAGE = "image";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_NICKNAME = "nickname";
    private static final String COLUMN_BIRTHDAY = "birthday";
    private static final String COLUMN_GMAIL = "gmail";
    private static final String COLUMN_ZALO = "zalo";
    private static final String COLUMN_FACEBOOK = "facebook";
    private static final String COLUMN_XSPACE = "xspace";
    private static final String COLUMN_INSTAGRAM = "instagram";
    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS TTBanBe(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "image BLOB, " +
                "name VARCHAR(50) NOT NULL, " +
                "nickname VARCHAR(50), " +
                "birthday VARCHAR(10), " +
                "gmail VARCHAR(50), " +
                "zalo VARCHAR(15), " +
                "facebook VARCHAR(50), " +
                "xspace VARCHAR(50), " +
                "instagram VARCHAR(50)" +
                ")";
        String drop = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<ThongTinBanBe> getAll(){
        List<ThongTinBanBe> data = new ArrayList<>();
        String[] objects = {
                DatabaseHelper.COLUMN_ID,
                DatabaseHelper.COLUMN_IMAGE,
                DatabaseHelper.COLUMN_NAME,
                DatabaseHelper.COLUMN_NICKNAME,
                DatabaseHelper.COLUMN_BIRTHDAY,
                DatabaseHelper.COLUMN_GMAIL,
                DatabaseHelper.COLUMN_ZALO,
                DatabaseHelper.COLUMN_FACEBOOK,
                DatabaseHelper.COLUMN_XSPACE,
                DatabaseHelper.COLUMN_INSTAGRAM
        };
        Cursor cursor = getReadableDatabase().query(DatabaseHelper.TABLE_NAME, objects, null, null, null, null, null);
        while(cursor.moveToNext()){
            ThongTinBanBe ttbb = new ThongTinBanBe(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID)),
                    cursor.getBlob(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_IMAGE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NICKNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_BIRTHDAY)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_GMAIL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ZALO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_FACEBOOK)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_XSPACE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_INSTAGRAM)));
            data.add(ttbb);
        }
        cursor.close();
        return data;
    }

    public ThongTinBanBe findOne(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] objects = {
                DatabaseHelper.COLUMN_ID,
                DatabaseHelper.COLUMN_IMAGE,
                DatabaseHelper.COLUMN_NAME,
                DatabaseHelper.COLUMN_NICKNAME,
                DatabaseHelper.COLUMN_BIRTHDAY,
                DatabaseHelper.COLUMN_GMAIL,
                DatabaseHelper.COLUMN_ZALO,
                DatabaseHelper.COLUMN_FACEBOOK,
                DatabaseHelper.COLUMN_XSPACE,
                DatabaseHelper.COLUMN_INSTAGRAM
        };
        String selection = COLUMN_ID + " = ?";
        String[] selectionArg = {String.valueOf(id)};
        Cursor cursor = db.query(TABLE_NAME, objects, selection, selectionArg, null, null, null);
        ThongTinBanBe ttbb = new ThongTinBanBe();
        if(cursor != null && cursor.moveToFirst()){
            ttbb.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)));
            ttbb.setImage(cursor.getBlob(cursor.getColumnIndexOrThrow(COLUMN_IMAGE)));
            ttbb.setName(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)));
            ttbb.setNickname(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NICKNAME)));
            ttbb.setBirthday(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BIRTHDAY)));
            ttbb.setGmail(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GMAIL)));
            ttbb.setZalo(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ZALO)));
            ttbb.setFb(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FACEBOOK)));
            ttbb.setXspace(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_XSPACE)));
            ttbb.setIns(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_INSTAGRAM)));
            cursor.close();
        }
        return ttbb;
    }

    public void insertData(ThongTinBanBe ttbb){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(COLUMN_IMAGE, ttbb.getImage());
        value.put(COLUMN_NAME, ttbb.getName());
        value.put(COLUMN_NICKNAME, ttbb.getNickname());
        value.put(COLUMN_BIRTHDAY, ttbb.getBirthday());
        value.put(COLUMN_GMAIL, ttbb.getGmail());
        value.put(COLUMN_ZALO, ttbb.getZalo());
        value.put(COLUMN_FACEBOOK, ttbb.getFb());
        value.put(COLUMN_XSPACE, ttbb.getXspace());
        value.put(COLUMN_INSTAGRAM, ttbb.getIns());
        db.insert(TABLE_NAME, null, value);
        db.close();
    }

    public void deleteData(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        db.delete(TABLE_NAME, selection, selectionArgs);
        db.close();
    }

    public void updateData(int id, ThongTinBanBe ttbb){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_IMAGE, ttbb.getImage());
        values.put(COLUMN_NAME, ttbb.getName());
        values.put(COLUMN_NICKNAME, ttbb.getNickname());
        values.put(COLUMN_BIRTHDAY, ttbb.getBirthday());
        values.put(COLUMN_GMAIL, ttbb.getGmail());
        values.put(COLUMN_ZALO, ttbb.getZalo());
        values.put(COLUMN_FACEBOOK, ttbb.getFb());
        values.put(COLUMN_XSPACE, ttbb.getXspace());
        values.put(COLUMN_INSTAGRAM, ttbb.getIns());

        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        db.update(TABLE_NAME, values, selection, selectionArgs);
        db.close();
    }
}
