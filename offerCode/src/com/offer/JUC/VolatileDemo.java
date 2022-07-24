package com.offer.JUC;

import java.util.concurrent.TimeUnit;

// 验证volatile的可见性
// 1.1 假如int number = 0； number变量之前根本没有添加volatitle关键字修饰
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addT060();
            System.out.println(Thread.currentThread().getName() + "\t update number value" + myData.number);
        },"AAA").start();

        // 第二个线程就是我们的main线程
        while (myData.number == 0){
            // main线程就一直再这里等待循环，直到number值不再等于0。
//            System.out.println("等于0");
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");

    }
}

class MyData{
    volatile int number = 0;
    public void addT060(){
        this.number = 60;
    }
}