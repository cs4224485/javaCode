package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    private int number = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void increment(){

        lock.lock();
        try {
            while (number!=0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            // 通知 唤醒
            condition.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void decrement(){
        lock.lock();

        try {
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t " + number);

            // 通知 唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        // T1线程生产
        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    shareData.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"t1").start();
        // t2线程 消费
        new Thread(() ->{
            for (int i = 0; i <5 ; i++) {
                try {
                    shareData.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"t2").start();
    }

}
