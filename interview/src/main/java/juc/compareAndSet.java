package juc;

import java.util.concurrent.atomic.AtomicInteger;

public class compareAndSet {
    public static void main(String[] args) {
        // 创建一个原子类
        AtomicInteger atomicInteger = new AtomicInteger(5);
        /***
         * 一个是期望值， 一个是更新值，但期望和原来的值相同时，才能够更正
         * 假设三秒前拿到的是5 也就是expect为5，然后需要更新成2019
         *
         */
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data: " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data: " + atomicInteger.get());
    }
}
