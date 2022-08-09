package com.voyager.java.core.thread;

public class Core_004_multi_thread {

    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread ty1 = new Thread(new Runner(), "ty1");
        Thread ty2 = new Thread(new Runner(), "ty2");
        ty1.start();
        ty2.start();
        ty1.join();
        ty2.join();
    }


    private static class Runner implements Runnable {

        @Override
        public void run() {
            synchronized (object) {
                long i =0;
                while(true){
//                System.out.println(Thread.currentThread().getName() + ">>>.\n");
                    i++;
                    i %= 100;
                }
            }

        }
    }
}
