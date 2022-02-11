package com.harry.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static java.lang.Thread.sleep;

@Slf4j(topic = "c.Test")
public class TestDeadLock {


    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                log.debug("lock A");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    log.debug("lock B");
                    log.debug("操作...");
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (B) {
                log.debug("lock B");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    log.debug("lock A");
                    log.debug("操作...");
                }
            }
        }, "t2");
        log.debug("deadlock");
        t1.start();
        t2.start();
    }

}

@Slf4j(topic = "c.room")
class BigRoom {
    private final Object studyRoom = new Object();
    private final Object bedRoom = new Object();
    public void sleep() throws InterruptedException {
        synchronized (bedRoom ) {
            log.debug("sleeping 2 小时");
            Thread.sleep(2000);
        }
    }

    public void study() throws InterruptedException {
        synchronized (studyRoom) {
            log.debug("study 1 小时");
            Thread.sleep(1000);
        }
    }
}