package com.voyager.java.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Core_002_daemon_thread {
    public static void main(String[] args) {
        System.out.println("Thread Started");
        // 主线程已处于运行中，无法修改线程状态
//        Thread.currentThread().setDaemon(true);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "[Started]");
        });


        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "[Started]");
        });
        thread.setDaemon(true);
        thread.start();
    }
}
