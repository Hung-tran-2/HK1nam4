package com.example.customlist;

import java.io.Serializable;

public class Model implements Serializable {
    String name;
    String gia;
    String soluong;

    public Model(String name, String gia, String soluong) {
        this.name = name;
        this.gia = gia;
        this.soluong = soluong;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getgia() {
        return gia;
    }

    public void setgia(String gia) {
        this.gia = gia;
    }

    public String getsoluong() {
        return soluong;
    }

    public void setsoluong(String soluong) {
        this.soluong = soluong;
    }
}