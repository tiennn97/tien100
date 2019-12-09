package com.tiennn.apphotrotimhieuluatgiaothong.models;

public class TinhHuong {
    private int id;
    private int anh;
    private String text;

    public TinhHuong(int anh, String text) {
        this.anh = anh;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
