package com.offer.JUC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 异步回调无返回值
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "没有返回， update mysql ok");
        });
        completableFuture.get();
        // 异步回调有返回值
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t completableFuture2");
            return 1024;
        });
        CompletableFuture<Integer> exceptionally = completableFuture2.whenComplete((t, u) -> {
            // 返回异步结果
            System.out.println("****t:" + t);
            // 出现异常的信息
            System.out.println("****u:" + u);
        }).exceptionally(f -> {
            // 处理异常
            System.out.println("***excption" + f.getMessage());
            return 444;
        });
        System.out.println(exceptionally.get());
    }
}
