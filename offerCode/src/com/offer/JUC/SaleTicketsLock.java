package com.offer.JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket2{
    private  int number = 100;
    private Lock lock = new ReentrantLock();
    public void saleTickets(){
        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第:"+ (number--)+"\t还剩下"+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class SaleTicketsLock {
    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        },"A").start();
    }

}
