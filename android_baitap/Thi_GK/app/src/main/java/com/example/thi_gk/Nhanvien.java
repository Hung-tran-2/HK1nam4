package com.example.thi_gk;

public class Nhanvien {

        private String msnv;
        private String ten;
        private int hesoluong;
        private boolean gioitinh;

        public Nhanvien(String msnv, String ten, int hesoluong, boolean gioitinh) {
            this.msnv = msnv;
            this.ten = ten;
            this.hesoluong = hesoluong;
            this.gioitinh = gioitinh;
        }

        public String getMsnv() {
            return msnv;
        }

        public String getTen() {
            return ten;
        }

        public int getHesoluong() {
            return hesoluong;
        }

        public boolean isGioitinh() {
            return gioitinh;
        }

}
