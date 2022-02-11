package com.harry.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.park")
public class TestPark {
    @Test
    public void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("start...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("park...");
            LockSupport.park();
            log.debug("resume...");
        },"t1");
        t1.start();
        Thread.sleep(2000);
        log.debug("unpark...");
        LockSupport.unpark(t1);
    }
    @Test
    public void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("start...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("park...");
            LockSupport.park();
            log.debug("resume...");
        }, "t1");
        t1.start();
        Thread.sleep(1000);
        log.debug("unpark...");
        LockSupport.unpark(t1);

    }
}
