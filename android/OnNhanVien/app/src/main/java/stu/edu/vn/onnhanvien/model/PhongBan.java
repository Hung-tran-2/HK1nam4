package stu.edu.vn.onnhanvien.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class PhongBan implements Serializable {
    private int id_pb;
    private String ten_pb;

    public int getId_pb() {
        return id_pb;
    }

    public void setId_pb(int id_pb) {
        this.id_pb = id_pb;
    }

    public String getTen_pb() {
        return ten_pb;
    }

    public void setTen_pb(String ten_pb) {
        this.ten_pb = ten_pb;
    }

    public PhongBan(int id_pb, String ten_pb) {
        this.id_pb = id_pb;
        this.ten_pb = ten_pb;
    }

    @NonNull
    @Override
    public String toString() {
        return ten_pb;
    }
}
