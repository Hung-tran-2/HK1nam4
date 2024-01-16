package stu.edu.vn.onnhanvien.model;

import java.io.Serializable;

public class NhanVien implements Serializable {
    public int id;
    public String tennv;
    public String birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }

    public String getMota_pb() {
        return mota_pb;
    }

    public void setMota_pb(String mota_pb) {
        this.mota_pb = mota_pb;
    }

    public int gioitinh;
    public String tenpb;

    public NhanVien(int id, String tennv, String birthday, int gioitinh, String tenpb, String mota_pb) {
        this.id = id;
        this.tennv = tennv;
        this.birthday = birthday;
        this.gioitinh = gioitinh;
        this.tenpb = tenpb;
        this.mota_pb = mota_pb;
    }

    public String mota_pb;
}
