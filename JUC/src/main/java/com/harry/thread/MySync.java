package com.harry.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MySync extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int acquires) {
        if (acquires ==1){
            if (compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int acquires) {
        if (acquires == 1){
            if (getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        return false;
    }

    protected Condition newCondition(){
        return new ConditionObject();
    }

    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}
@Slf4j(topic = "c.test")
class MyLock implements Lock {
    static MySync sync = new MySync();

    @Override
    // 尝试不成功进入等待队列
    public void lock() {
        sync.acquire(1);
    }

    @Override
    // 尝试，不成功进入等待队列，可打断
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    // 尝试一次，不成功返回，不进入队列
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    // 尝试不成功，进入等待队列，有时限
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    // 释放锁
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        new Thread(()->{
            myLock.lock();
            try {
                log.debug("locking");
            }finally {
                log.debug("unlocking");
                myLock.unlock();
            }
        }, "t1").start();

        new Thread(()->{
            myLock.lock();
            try {
                log.debug("locking");
            }finally {
                log.debug("unlocking");
                myLock.unlock();
            }
        }, "t2").start();

    }
}
