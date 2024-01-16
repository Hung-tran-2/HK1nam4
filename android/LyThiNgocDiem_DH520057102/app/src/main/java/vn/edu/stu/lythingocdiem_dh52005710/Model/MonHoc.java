package vn.edu.stu.lythingocdiem_dh52005710.Model;

import com.google.gson.annotations.SerializedName;

public class MonHoc {
    @SerializedName("ma")
    private int ma;
    @SerializedName("ten")
    private String ten;

    public MonHoc(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
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

    public MonHoc() {
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                '}';
    }
}
