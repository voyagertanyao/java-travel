package com.voyager.java.core.thread;

public class Core_003_volatile {
    public static void main(String[] args) {
        Inner inner = new Inner();

        new Thread(()->{
            try {
                for (int i = 0; i < 1000000; i++) {
                    inner.write();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "=> " + inner.a);
        },"write-thread").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 1000000; i++) {
                    inner.write();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "=> " + inner.a);
        },"read-thread").start();
    }
}

class Inner {
    volatile int a = 0;
//    volatile boolean flag = false;

    public void write() throws InterruptedException {
        ++a;
//        Thread.sleep(1);
//        for(int i=1; i<1000000; i++){
//            a=a+i;
//        }
//        flag = true;
    }

//    public void read() throws InterruptedException {
////        Thread.sleep(1);
//        if(flag){
//            a = 2;
//        }
//    }
}
