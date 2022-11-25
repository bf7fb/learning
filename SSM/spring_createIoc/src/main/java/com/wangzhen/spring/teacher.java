package com.wangzhen.spring;

public class teacher implements Person{
    private int tId;
    private String tName;

    public teacher() {
    }

    public teacher(int tId, String tName) {
        this.tId = tId;
        this.tName = tName;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                '}';
    }
}
