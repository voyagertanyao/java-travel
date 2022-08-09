package com.voyager.java.core.access.a1;

public class BaseClass {

    static String stat;

    static void stat(){
        System.out.println("static public void stat()");
    }

    private String priv;

    String pkg;

    public String pub;

    protected String prot;

    private void priv(){
        System.out.println("private void priv()");
    }

    void pkg(){
        System.out.println("void pkg()");
    }

    public void pub(){
        System.out.println("public void pub()");
    }

    protected void prot(){
        System.out.println("protected void prot()");
    }
}
