package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * 1 验证volatile的可见性
 *  1.1 假如int number = 0； number变量之前根本没有添加volatitle关键字修饰
 *  1.2 添加了volatile，可以解决可见性问题
 * 2 验证volatile不保证原子性
 *  2.1 原子性的意思：不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以加塞或者被分割 需要整体完整，要么同事成功，要么同时失败
 *  2.2 解决方法：使用AtomicInteger
 *
 * */


public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i <20000 ; i++) {
            new Thread(() ->{
                myData.plus();
                myData.addAtomic();
            },i+"").start();
        }

        while (Thread.activeCount() >2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t atomic update number value" + myData.atomicInteger);
    }
    public static void seeOkByVolatiele(){
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addT060();
            System.out.println(Thread.currentThread().getName() + "\t int update number value" + myData.number);

        },"AAA").start();

        // 第二个线程就是我们的main线程
        while (myData.number == 0){
            // main线程就一直再这里等待寻黄，直到number值不再等于。
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
    public void plus(){
        number++;
    }
    AtomicInteger atomicInteger = new AtomicInteger(0);
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}