package com.harry.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.StampedLock;

import static java.lang.Thread.sleep;

@Slf4j(topic = "c.test")
public class DataContainerStamped {
    private int data;

    private final StampedLock lock = new StampedLock();

    public DataContainerStamped(int data){
        this.data = data;
    }

    public int read(int readTime) throws InterruptedException {
        long stamp = lock.tryOptimisticRead();
        log.debug("optimistic read locking...{}", stamp);
        sleep(readTime);
        if (lock.validate(stamp)) {
            log.debug("read finish...{}, data:{}", stamp, data);
            return data;
        }
        // 锁升级 - 读锁
        log.debug("updating to read lock... {}", stamp);
        try {
            stamp = lock.readLock();
            log.debug("read lock {}", stamp);
            sleep(readTime);
            log.debug("read finish...{}, data:{}", stamp, data);
            return data;
        } finally {
            log.debug("read unlock {}", stamp);
            lock.unlockRead(stamp);
        }

    }

    public void write(int newData) {
        long stamp = lock.writeLock();
        log.debug("write lock {}", stamp);
        try {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = newData;
        } finally {
            log.debug("write unlock {}", stamp);
            lock.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DataContainerStamped dataContainer = new DataContainerStamped(1);
        new Thread(() -> {
            try {
                dataContainer.read(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        sleep(500);
        new Thread(() -> {
            dataContainer.write(3000);
        }, "t2").start();
    }

}
