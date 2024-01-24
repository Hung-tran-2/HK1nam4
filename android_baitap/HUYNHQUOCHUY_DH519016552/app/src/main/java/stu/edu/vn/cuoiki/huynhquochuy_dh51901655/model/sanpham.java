package stu.edu.vn.cuoiki.huynhquochuy_dh51901655.model;

import java.io.Serializable;

public class sanpham  implements Serializable {
    private String masp;
    private String tensp;
    private float gia;
    private int nam;

    public sanpham() {
    }

    public sanpham(String masp, String tensp, float gia, int nam) {
        this.masp = masp;
        this.tensp = tensp;
        this.gia = gia;
        this.nam = nam;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    @Override
    public String toString() {
        return "sanpham{" +
                "masp='" + masp + '\'' +
                ", tensp='" + tensp + '\'' +
                ", gia=" + gia +
                ", nam=" + nam +
                '}';
    }
}
