package stu.edu.lab7.model;



import java.text.Format;
import java.util.Date;

import stu.edu.lab7.util.FormatUtil;


public class DatPhong {
    private String ma;
    private String tenNguoiDat;
    private Date ngayDat;
    private int soDem;

    public DatPhong() {

    }
    public DatPhong(String ma, String tenNguoiDat, Date ngayDat, int soDem) {
        this.ma = ma;
        this.tenNguoiDat = tenNguoiDat;
        this.ngayDat = ngayDat;
        this.soDem = soDem;
    }
    public String getMa (){
        return ma;
    }
    public void setMa (String ma) {
        this.ma = ma;
    }
    public String getTenNguoiDat () {
        return tenNguoiDat;
    }
    public void setTenNguoiDat(String tenNguoiDat) {
        this.tenNguoiDat = tenNguoiDat;
    }
    public  Date getNgayDat() {
        return ngayDat;
    }
    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }
    public  int getSoDem () {
        return soDem;
    }
    public  void setSoDem (int soDem) {
        this.soDem =soDem;
    }
    public String toString() {
        return "Mã đặt:" + ma + "\n"
                + "Người đặt:" + tenNguoiDat + "\n"
                + "Ngày đặt:"  + FormatUtil.formatDate(ngayDat) + "\n"
                + "Số dếm:"    + soDem;

    }


}