package com.offer.JUC;

class Ticket{ // 资源类
    private int number = 130;
    public synchronized  void saleTicket(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"\t卖出第:"+ (number--)+"\t还剩下"+number);
        }
    }
}

/**
 * 三个售票员 卖出 30张票
 * 在高内聚低耦合的前提下，线程  操作(对外暴露的调用方法) 资源类
 */
public class SaleTickets {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40 ; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket.saleTicket();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <40 ; i++) {
                    ticket.saleTicket();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40 ; i++) {
                    ticket.saleTicket();
                }
            }
        },"C").start();
    }
}
