package com.harry.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CountdownLatchTest2 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger num = new AtomicInteger();
        ExecutorService service = Executors.newFixedThreadPool(10, (r) -> {
            return new Thread(r, "t" + num.getAndIncrement());
        });

        CountDownLatch countDownLatch = new CountDownLatch(10);
        String[] all = new String[10];
        Random r = new Random();
        for (int j=0; j < 10; j++){
            int x = j;
            service.submit(() -> {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(r.nextInt(100));
                    } catch (InterruptedException e) {
                    }
                    all[x] = Thread.currentThread().getName() + "(" + (i + "%") + ")";
                    System.out.print("\r" + Arrays.toString(all));
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("\n游戏开始...");
        service.shutdown();
}}
