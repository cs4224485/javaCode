package com.offer.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource {
    private int i = 1; //1:a 2:b 3:c
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public void print() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("A")) {
            doPrint(condition1, condition2,5, threadName,1,2);
        } else if (threadName.equals("B")) {
            doPrint(condition2, condition3,10, threadName,2,3);
        }else if (threadName.equals("C")){
            doPrint(condition3, condition1,15, threadName,3,1);
        }
    }

    public void doPrint(Condition condition,Condition target, int count, String threadName, int k, int flag) {
        /***
         *  condition: 当前线程的condition
         *  target: 下一个要调度线程的condition
         *  count： 打印次数
         *  treadName: 线程名称
         *  k: 当前线程的标志位
         *  flag: 要执行下一个线程的标志位
         */
        lock.lock();
        try {
            while (i != k) {
                condition.await();
            }
            for (int j = 0; j < count; j++) {
                System.out.println(threadName + "\t" + j);
            }
            i = flag;
            target.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

/**
 * 多线程之间顺序调用， 实现A-B-C
 * 三个线程启动，要求如下：
 * AA打印5次，BB打印10次， CC打印15次
 * 接着
 * AA打印5次，BB打印10次， CC打印15次来10轮
 */

/**
 * 1 高聚低合前提下，线程操作资源类
 * 2 判断/干活/通知
 * 3 多线程交互中，必须要防止多线程的虚假呼唤， 也即(判断只用while，不能用if)
 * 4 使用标志位
 * ReentrantLock和Condition配合使用实现精准通知，精准唤醒
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() ->{
            for (int i = 0; i <10 ; i++) {
                shareResource.print();
            }
        },"A").start();

        new Thread(() ->{
            for (int i = 0; i <10 ; i++) {
                shareResource.print();
            }
        },"B").start();

        new Thread(() ->{
            for (int i = 0; i <10 ; i++) {
                shareResource.print();
            }
        },"C").start();

    }
}
