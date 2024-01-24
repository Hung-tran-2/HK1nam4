package com.example.quanlybaihat_sqlite.model;

import java.io.Serializable;

public class    baihat implements Serializable {
        private String ma;
        private String ten;
        private String tacgia;
        private int thoiluong;


    public baihat(String ma, String ten, String tacgia, int thoiluong) {
        this.ma = ma;
        this.ten = ten;
        this.tacgia = tacgia;
        this.thoiluong = thoiluong;
    }

    public baihat() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(int thoiluong) {
        this.thoiluong = thoiluong;
    }

    @Override
    public String toString() {
        return "baihat{" +
                "ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", tacgia='" + tacgia + '\'' +
                ", thoiluong=" + thoiluong +
                '}';
    }
}
