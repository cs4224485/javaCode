package com.offer.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(4);

        System.out.println("test Callable");
        return 1024;
    }
}

/***
 * 多线程中，第三种获得多线程的方式
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"A").start();
        System.out.println("---main-----");
        System.out.println(futureTask.get());// 从futureTask获取返回值

    }
}
