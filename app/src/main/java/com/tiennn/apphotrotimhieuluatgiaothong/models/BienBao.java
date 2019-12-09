package com.tiennn.apphotrotimhieuluatgiaothong.models;

public class BienBao {
    private int id;
    private int anh;
    private String text;
    private String text1;

    public BienBao(int anh, String text, String text1) {
        this.anh = anh;
        this.text = text;
        this.text1 = text1;
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

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }
}
