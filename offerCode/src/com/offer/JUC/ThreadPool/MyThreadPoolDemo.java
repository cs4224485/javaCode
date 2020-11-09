package com.offer.JUC.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * 线程池底层流程：
 * 1. 在创建了线程池后，开始等待请求。
 * 2. 当调用execute()方法添加一个请求任务时，线程池会做出如下判断：
 *  2.1 如果正在运行的线程数量小于corePoolSize,那么马上创建线程运行这个任务
 *  2.2 如果正在运行的线程数量大于或等于corePoolSize， 那么将这个任务放入队列
 *  2.3 如果这个时候队列满了且正在运行的线程数量还小于maximumPoolSize,那么还是要创建非核心线程立刻运行这个任务
 *  2.4 如果队列满了且正在运行的线程数量大于或等于maximumPoolSize 那么线程池会启动饱和和拒绝策略来执行
 * 3. 当一个线程完成任务时，它会从队列中取下一个任务来执行
 * 4. 当一个线程无事可做超过一定的实际(keepAliveTime)时,线程会判断：
 *  如果当前运行的线程数大于corePoolSize,那么这个线程会被停掉。
 *  所以线程的所有任务完成后，它最终会缩到corePoolSize的大小。
 */

/**
 * newFixedThreadPool/newSingleThreadExecutor/newCachedThreadPool这三个本质上都是ThreadPoolExecutor
 * 线程池中的七大参数：
 *  1. corePoolSize:线程池中的常驻核心线程数
 *  2. maximumPoolSize: 线程池中能够容纳同时执行的最大线程数，此值必须大于等于1
 *  3. keepAliveTime:多余的空闲线程的存活时间，当前池中线程数量超过corePoolSize,当空闲时间达到keepAliveTime时，多余线程会被销毁知道只剩下corePoolSize这个线程为止
 *  4. unit:keepAliveTime的单位
 *  5. workQueue: 任务对垒，被提交尚未被执行的任务
 *  6. threadFactory: 表示生成线程池中工作线程的线程工厂，用于创建线程，一般默认即可
 *  7. handle:拒绝策略，表示当队列满了，并且工资线程大于等于线程池的最大线程数(maximumPoolSize)时如何来拒绝请求执行的runnable的策略
 *
 */

public class MyThreadPoolDemo {
    public static void main(String[] args) {
       // ExecutorService threadPool =  Executors.newFixedThreadPool(5); // 一池5线程
       // ExecutorService threadPool = Executors.newSingleThreadExecutor();// 一池1线程
        ExecutorService threadPool = Executors.newCachedThreadPool(); // 一池N个工作线程

        try{
            for (int i = 0; i <10 ; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
