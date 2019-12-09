package com.tiennn.apphotrotimhieuluatgiaothong.models;

public class Luat {
    private int id;
    private String text2;
    private String text3;

    public Luat(int id, String text2, String text3) {
        this.id = id;
        this.text2 = text2;
        this.text3 = text3;
    }

    public Luat(String text2, String text3) {
        this.text2 = text2;
        this.text3 = text3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }
}

