package juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(6);

    public static void main(String[] args) {
        for (int i = 0; i <6 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "\t 班长最后关门");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
