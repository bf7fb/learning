package com.wangzhen.spring;

import java.util.List;

public class Clazz {
    private int id;
    private String name;
    private List<student> students;

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clazz(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Clazz() {
    }
}
