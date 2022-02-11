package com.harry.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

@Slf4j(topic = "c.test")
public class DataContainer {
    private Object data;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock r = rw.readLock();
    private ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public Object read() throws InterruptedException {
        log.debug("获取读锁。。。。");
        r.lock();
        try {
            log.debug("读取");
            sleep(1000);
            return data;
        }finally {
            log.debug("释放读锁");
            r.unlock();
        }
    }
    public void write() throws InterruptedException {
        log.debug("获取写锁...");
        w.lock();
        try {
            log.debug("写入");
            sleep(1000);
        } finally {
            log.debug("释放写锁...");
            w.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        DataContainer dataContainer = new DataContainer();
        log.debug("main test");
        new Thread(() ->{
            try {
                log.debug("t1 read");
                dataContainer.read();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
//        Thread.sleep(1000);
        new Thread(() ->{
            try {
                log.debug("t2 write");
                dataContainer.write();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();

    }

}
@Slf4j(topic = "c.DataContainer")
class TestReadWrite{
    public static void main(String[] args) {

        DataContainer dataContainer = new DataContainer();
        new Thread(() ->{
            try {
                dataContainer.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        new Thread(() ->{
            try {
                dataContainer.write();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");

    }
}
