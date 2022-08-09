package com.voyager.java.core.extend;

public class Extend extends Base{
    public Extend() {
        super("base class");
    }

    @Override
    protected String get() {
        return super.get() + " extend";
    }


    public static void main(String[] args) {
        Extend extend = new Extend();
        System.out.println(extend.get());
    }
}
