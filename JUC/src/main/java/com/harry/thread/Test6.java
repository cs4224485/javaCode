package com.harry.thread;

import javafx.scene.control.Cell;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.LongBinaryOperator;
import java.util.function.Supplier;

public class Test6 {
    private volatile int field;

    public static void main(String [] args){
        AtomicIntegerFieldUpdater fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Test6.class, "field");
        Test6 test6 = new Test6();
        fieldUpdater.compareAndSet(test6, 0, 10);
        // 修改成功 field = 10
        System.out.println(test6.field);
        // 修改成功 field = 20
        fieldUpdater.compareAndSet(test6, 10, 20);
        System.out.println(test6.field);
        // 修改失败 field = 20
        fieldUpdater.compareAndSet(test6, 10, 30);
        System.out.println(test6.field);

        for (int i = 0; i < 5; i++) {
            demo(() -> new LongAdder(), adder -> adder.increment());
        }
        for (int i = 0; i < 5; i++) {
            demo(() -> new AtomicLong(), adder -> adder.getAndIncrement());
        }


    }

    private static <T> void demo(Supplier<T> adderSupplier, Consumer<T> action) {
        T adder = adderSupplier.get();
        long start = System.nanoTime();
        List<Thread> ts = new ArrayList<>();
        // 4 个线程，每人累加 50 万
        for (int i = 0; i < 40; i++) {
            ts.add(new Thread(() -> {
                for (int j = 0; j < 500000; j++) {
                    action.accept(adder);
                }
            }));
        }
        ts.forEach(t -> t.start());
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();}
        });
        long end = System.nanoTime();
        System.out.println(adder + " cost:" + (end - start)/1000_000);
    }




}
