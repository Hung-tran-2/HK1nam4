package vn.edu.stu.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import vn.edu.stu.myapplication.model.NhanVien;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QLNV.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NV = "NhanVien";
    private static final String COLUMN_MANV = "MaNV";
    private static final String COLUMN_TENNV = "TenNV";
    private static final String COLUMN_GIOITINH = "GioiTinh";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NV + " (" +
                COLUMN_MANV + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TENNV + " TEXT, " +
                COLUMN_GIOITINH + " INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NV);
        onCreate(db);
    }

    // Thêm nhân viên mới
    public long addNhanVien(NhanVien nhanVien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TENNV, nhanVien.getTenNV());
        values.put(COLUMN_GIOITINH, nhanVien.isGioiTinh() ? 1 : 0);

        long result = db.insert(TABLE_NV, null, values);
        db.close();
        return result;
    }

    // Lấy danh sách nhân viên từ cơ sở dữ liệu
    public ArrayList<NhanVien> getNhanVienList() {
        ArrayList<NhanVien> nhanVienList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NV;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int maNV = cursor.getInt(cursor.getColumnIndex(COLUMN_MANV));
                String tenNV = cursor.getString(cursor.getColumnIndex(COLUMN_TENNV));
                boolean gioiTinh = cursor.getInt(cursor.getColumnIndex(COLUMN_GIOITINH)) == 1;

                NhanVien nhanVien = new NhanVien(maNV, tenNV, gioiTinh);
                nhanVienList.add(nhanVien);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return nhanVienList;
    }

    // Xoá nhân viên theo mã NV
    public long deleteNhanVien(int maNV) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NV, COLUMN_MANV + " = ?", new String[]{String.valueOf(maNV)});
        db.close();
        return result;
    }

    // Cập nhật thông tin nhân viên
    public long updateNhanVien(NhanVien nhanVien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TENNV, nhanVien.getTenNV());
        values.put(COLUMN_GIOITINH, nhanVien.isGioiTinh() ? 1 : 0);

        long result = db.update(TABLE_NV, values, COLUMN_MANV + " = ?",
                new String[]{String.valueOf(nhanVien.getMaNV())});

        db.close();
        return result;
    }
}
