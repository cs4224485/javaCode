package com.offer.JUC;

class Task {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        // 判断
        while (number != 0) {
            this.wait();
        }
        // 干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 通知
        this.notify();
    }

    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notify();
    }
}

/**
 * 题目：现在两个线程，可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1， 一个线程对该变量减1
 * 实现交替， 来10轮， 变量初始值为零。
 * 1 高聚低合前提下，线程操作资源类
 * 2 判断/干活/通知
 * 3 多线程交互中，必须要防止多线程的虚假呼唤， 也即(判断只用while，不能用if)
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    task.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    task.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }

}
