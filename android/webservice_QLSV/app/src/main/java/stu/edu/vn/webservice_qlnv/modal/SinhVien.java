package stu.edu.vn.webservice_qlnv.modal;

public class SinhVien {
    private int ma;
    private String ten;

    public SinhVien(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
    public SinhVien() {

    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
