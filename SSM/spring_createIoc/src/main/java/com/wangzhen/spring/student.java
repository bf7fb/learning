package com.wangzhen.spring;

import java.util.Arrays;
import java.util.Map;

public class student implements Person{
    private int id;
    private String sname;
    private String ssex;
    private double score;
    private int age;
    private Clazz clazz;
    private String hobby[];
    private Map<String,teacher> mapTeachers;

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", score=" + score +
                ", age=" + age +
                ", clazz=" + clazz +
                ", hobby=" + Arrays.toString(hobby) +
                ", mapTeachers=" + mapTeachers +
                '}';
    }

    public Map<String, teacher> getMapTeachers() {
        return mapTeachers;
    }

    public void setMapTeachers(Map<String, teacher> mapTeachers) {
        this.mapTeachers = mapTeachers;
    }

    public student() {
    }

    public student(int id, String sname, String ssex) {
        this.id = id;
        this.sname = sname;
        this.ssex = ssex;
    }

    public student(int id, String sname, String ssex, double score) {
        this.id = id;
        this.sname = sname;
        this.ssex = ssex;
        this.score = score;
    }
    public student(int id, String sname, String ssex, int age) {
        this.id = id;
        this.sname = sname;
        this.ssex = ssex;
        this.age = age;
    }

    public double getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

}
