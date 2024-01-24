package stu.edu.vn.trannhunguyen_dh52007186.model;

import java.io.Serializable;

public class Sach implements Serializable {

    private String ma;
    private String ten;
    private String tacgia;
    private int thoiluong;

    public Sach()  {
    }

    public Sach(String ma, String ten, String tacgia, int thoiluong) {
        this.ma = ma;
        this.ten = ten;
        this.tacgia = tacgia;
        this.thoiluong = thoiluong;
    }

    @Override
    public String toString() {
        return
                "Mã:" + ma +
                ", Tên:'" + ten + '\'' +
                ", Tác giả:'" + tacgia + '\'' +
                ", Nhà xuất bản:" + thoiluong ;
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

    public int getNamxuatban() {
        return thoiluong;
    }

    public void setNamxuatban(int namxuatban) {
        this.thoiluong = namxuatban;
    }
}
