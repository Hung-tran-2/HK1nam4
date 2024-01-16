package com.example.doan.model;

import java.io.Serializable;

public class ThongTinBanBe implements Serializable {
    private int id;
    private byte[] image;
    private String name;
    private String nickname;
    private String birthday;
    private String gmail;
    private String zalo;
    private String fb;
    private String xspace;
    private String ins;

    public ThongTinBanBe() {

    }

    public ThongTinBanBe(int id, byte[] image, String name, String nickname, String birthday, String gmail, String zalo, String fb, String xspace, String ins) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.nickname = nickname;
        this.birthday = birthday;
        this.gmail = gmail;
        this.zalo = zalo;
        this.fb = fb;
        this.xspace = xspace;
        this.ins = ins;
    }

    public ThongTinBanBe(byte[] image, String name, String nickname, String birthday, String gmail, String zalo, String fb, String xspace, String ins) {
        this.image = image;
        this.name = name;
        this.nickname = nickname;
        this.birthday = birthday;
        this.gmail = gmail;
        this.zalo = zalo;
        this.fb = fb;
        this.xspace = xspace;
        this.ins = ins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getZalo() {
        return zalo;
    }

    public void setZalo(String zalo) {
        this.zalo = zalo;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getXspace() {
        return xspace;
    }

    public void setXspace(String xspace) {
        this.xspace = xspace;
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }
}
