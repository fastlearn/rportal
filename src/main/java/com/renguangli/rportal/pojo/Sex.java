package com.renguangli.rportal.pojo;

public enum Sex {

    MAN(0, "男"), //男

    WOMEN(1, "女"); //女

    private int value;

    private String name;

    Sex(int value, String name) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
