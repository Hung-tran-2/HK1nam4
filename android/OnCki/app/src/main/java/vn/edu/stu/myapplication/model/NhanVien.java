package vn.edu.stu.myapplication.model;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private int maNV;
    private String tenNV;
    private boolean gioiTinh;
    public NhanVien(){

    }
    public NhanVien(int maNV, String tenNV, boolean gioiTinh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
    }

    public int getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
