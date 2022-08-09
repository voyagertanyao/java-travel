package com.voyager.java.core.extend;

public class Base {

    public static String func(){
        return "Base";
    }

    private final String desc;

    public Base(String desc) {
        this.desc = desc;
    }

    protected String get(){
        return this.desc;
    }
}
