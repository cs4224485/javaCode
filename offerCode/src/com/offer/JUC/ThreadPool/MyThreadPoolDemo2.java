package com.offer.JUC.ThreadPool;


import java.util.concurrent.*;

/***
 * 使用ThreadPoolExecutor
 * 拒绝策略：
 * 1 ThreadPoolExecutor.AbortPolicy()
 *   默认参数，直接抛出java.util.concurrent.RejectedExecutionException异常阻止系统正常运行
 * 2 CallerRunsPolicy
 *   调用者运行一种调节机制，该策略既不会抛弃任务，也不会抛出异常，而是将某些任务回退到调用者，从而降低新任务的流量。
 * 3 DiscardOldestPolicy
 *   抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试再次提交当前任务
 * 4 DiscardPolicy
 *   该策略默默地抛弃无法处理的任务， 不予任何处理也不抛出异常。 如果允许任务丢失，这是最好的一种策略
 *
 *
 */
public class MyThreadPoolDemo2 {
    public static void main(String[] args) {

        ExecutorService threadPool = new ThreadPoolExecutor(2
                , 5,
                3L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 0; i < 9; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
