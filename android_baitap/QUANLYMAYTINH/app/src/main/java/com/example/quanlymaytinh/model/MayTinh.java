package com.example.quanlymaytinh.model;

import java.io.Serializable;

public class MayTinh implements Serializable {
  private  int maMay;
    private String tenMay;
    private int soLuong;
    private float giaTien;

    public MayTinh() {
    }

    public MayTinh(int maMay, String tenMay, int soLuong, float giaTien) {
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public int getMaMay() {
        return maMay;
    }

    public void setMaMay(int maMay) {
        this.maMay = maMay;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "MayTinh{" +
                "maMay=" + maMay +
                ", tenMay='" + tenMay + '\'' +
                ", soLuong=" + soLuong +
                ", giaTien=" + giaTien +
                '}';
    }
}
