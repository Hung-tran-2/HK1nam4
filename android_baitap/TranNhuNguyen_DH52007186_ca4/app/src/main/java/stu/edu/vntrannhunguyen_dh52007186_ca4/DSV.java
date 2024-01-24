package stu.edu.vntrannhunguyen_dh52007186_ca4;

public class DSV {
    private String msv;
    private String ten;
    private String lop;
    private boolean gioitinh;
    public DSV(String msv, String mten, String lop, boolean gioitinh) {
        this.msv = msv;
        this.ten = mten;
        this.lop = lop;
        this.gioitinh = gioitinh;
    }
    public String getMsnv() {
        return msv;
    }

    public String getTen() {
        return ten;
    }

    public String getHesoluong() {
        return lop;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }
}









