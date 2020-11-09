package com.offer.JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/***
 * 当队列是空的，从队列中获取元素的操作将会被阻塞
 * 当队列是满的，从队列中添加元素的操作将会被阻塞
 * 试图从空的队列中获取元素的线程将会被阻塞，直到其他线程往空的队列插入新的元素
 * 试图向自己满的队列中添加新元素的线程将会被阻塞，知道其他线程从队列中移除一个或多个元素或者完全清空，使队列变得空闲起来并后续新增
 *
 * 在多线程领域：所谓阻塞，在某些情况下会挂起线程(即阻塞), 一旦条件满足，被挂起的线程又会自动被唤起
 *  为什么需要BlockingQueue：好处是我们不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程，因为这一切BlockingQueue都包办了
 *
 *
 *
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        // 当队列满时，再往队列add插入元素会抛出，IllegalStateException:Queue full
//        blockingQueue.add("a");
//        blockingQueue.add("b");
//        blockingQueue.add("c");
        // 抛出异常
        //blockingQueue.add("c");
        // 当阻塞队列空时， 在往队列里remove移除元素会抛NoSuchElementException
//        System.out.println(blockingQueue.remove());
        // 检查
//        System.out.println(blockingQueue.element());
        // 特殊值: 擦汗如方法成功返回true否则false
//        System.out.println(blockingQueue.offer("a"));
//        blockingQueue.offer("b");
//        blockingQueue.offer("c");
//        移除方法， 成功返回队列元素，队列里没有返回null
//        blockingQueue.poll();
//        一直阻塞： 当前阻塞队列满时，生产者线程继续往队列里put元素，队列会一直阻塞生产线程知道put数据or响应中断退出
//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//        blockingQueue.put("d");
        // 当阻塞队列空时，消费者线程试图从队列里take元素， 队列会一直阻塞消费者线程直到队列可用

//          blockingQueue.take();

        blockingQueue.offer("a");
        blockingQueue.offer("c");
        blockingQueue.offer("d");
        // 当队列满是，队列会阻塞生产者线程一定时间，超过限时后生产者线程会退出
        blockingQueue.offer("e", 3, TimeUnit.SECONDS);
        blockingQueue.poll(3, TimeUnit.SECONDS);


    }
}
