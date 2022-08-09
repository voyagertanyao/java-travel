package com.voyager.java.core.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Core_001_create_thread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. runnable
        Thread thread1 = new Thread(new TaskRunnable());
        thread1.start();

        // 2. callable
        FutureTask<String> future = new FutureTask<>(new TaskCallable());
        Thread thread2 = new Thread(future);
        thread2.start();
        System.out.println(future.get());

        // 3. thread
        new TaskThread().start();

    }
}

class TaskRunnable implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " --> Runnable");
    }
}


class TaskCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String name = Thread.currentThread().getName();
        return name + " --> Callable";
    }
}

class TaskThread extends Thread {
    @Override
    public void run() {
        super.run();
        String name = Thread.currentThread().getName();
        System.out.println(name + " --> Thread");
    }
}
