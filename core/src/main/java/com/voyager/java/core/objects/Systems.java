package com.voyager.java.core.objects;

public class Systems {
    public static void main(String[] args) {
//        System.getProperties().list(System.out);

        byte b = 0b10110;
        int f = 0xff;
        short o = 077;
        int a = 123_456;
        System.out.println(Integer.toOctalString(o));
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
