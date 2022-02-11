package com.harry.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

@Slf4j(topic = "c.thread")
public class TestThread {
    @Test
    public void test1(){
        Thread thread = new Thread("t1"){
            public void run(){
                log.debug("hello");
            }
        };
        thread.start();
    }
    @Test
    public void test2(){
        // 创建任务对象
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                log.debug("hello");
            }
        };
        // 参数1 是任务对象; 参数2 是线程名字，推荐
        Thread t2 = new Thread(task2, "t2");
        t2.start();
    }
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        // 创建任务对象
        FutureTask<Integer> task3 = new FutureTask<>(() -> {
            log.debug("hello");
            return 100;
        });
        // 参数1 是任务对象; 参数2 是线程名字，推荐
        new Thread(task3, "t3").start();
        // 主线程阻塞，同步等待 task 执行完毕的结果
        Integer result = task3.get();
        log.debug("结果是:{}", result);
    }

    @Test
    public void test4(){
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug(Thread.currentThread().getName());
//                FileReader.read(Constants.MP4_FULL_PATH);
            }
        };
        t1.run();
        log.debug("do other things ...");

    }
    @Test
    public void test5(){
        Runnable task1 = ()->{
            int count = 0;
            for (;;){
                System.out.println("---->1 " + count++);
            }
        };
        Runnable task2 = ()->{
            int count = 0;
            for (;;){
                Thread.yield();
                System.out.println("---->2 " + count++);
            }
        };
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        t1.start();
        t2.start();


    }
    static int r = 0;
    @Test
    public void test6() throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            log.debug("Start");
            try {
                sleep(1);
                log.debug("结束");
                r = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t1.join();
        log.debug("结果为：{}", r);
        log.debug("结束");
    }
    static int r1 = 0;
    static int r2 = 0;

    @Test
    public void test7() throws InterruptedException{
        Thread t1 = new Thread(() -> {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        });
        Thread t2 = new Thread(() -> {
            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r2 = 20;
        });
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} cost: {}", r1, r2, end - start);
    }
    @Test
    public void test8() throws InterruptedException{
        Thread t1 = new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        });
        long start = System.currentTimeMillis();
        t1.start();
        // 线程执行结束会导致 join 结束
        t1.join(1500);
        long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} cost: {}", r1, r2, end - start);
    }
    @Test
    public void test9() throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        sleep((long) 0.5);
        t1.interrupt();
        log.debug(" 打断状态: {}", t1.isInterrupted());

    }
    @Test
    public void test10() throws InterruptedException {
        Thread t2 = new Thread(()->{
            while(true) {
                Thread current = Thread.currentThread();
                boolean interrupted = current.isInterrupted();
                if(interrupted) {
                    log.debug(" 打断状态: {}", interrupted);
                    break;
                }
            }
        }, "t2");
        t2.start();
        sleep((long) 0.5);
        t2.interrupt();
    }
    @Test
    public void test11() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
            log.debug("打断状态：{}", Thread.currentThread().isInterrupted());
        }, "t1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }

    @Test
    public void test12() throws InterruptedException {
        log.debug("开始运行...");
        Thread t1 = new Thread(() -> {
            log.debug("开始运行...");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("运行结束...");
        }, "daemon");
        // 设置该线程为守护线程
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(1000);
        log.debug("运行结束...");
    }
}
