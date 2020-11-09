package com.offer.JUC;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket3 {
    private String name;
    private int Number;

    public Ticket3(String name, int Number) {
        this.name = name;
        this.Number = Number;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
}

class Window{
    private static AtomicInteger i = new AtomicInteger();
    private List<Ticket3> ticket;
    private Lock lock = new ReentrantLock();
    public Window(List<Ticket3> ticket) {
        this.ticket = ticket;
    }

    public void saleTicket(){
        while (true){

            if(i.get() +3 < ticket.size()){
                try {
                    Thread.sleep(new Random().nextInt(150));
                    lock.lock();
                    Ticket3 t = ticket.get(i.incrementAndGet());
                    System.out.println(Thread.currentThread().getName() + "卖票" + t.getName()+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }finally {
                    lock.unlock();
                }
            }else {
                System.out.println("票卖完了");
                break;
            }

        }
    }
}

public class SaleTicketLambda {
    public static void main(String[] args) {
        ArrayList<Ticket3> TicketList = new ArrayList<Ticket3>();
        for (int i = 0; i <= 1000; i++) {
            Ticket3 tic = new Ticket3("火车票", i);
            TicketList.add(tic);
        }
        Window window = new Window(TicketList);
        new Thread(()->{window.saleTicket();},"A").start();
        new Thread(()->{window.saleTicket();},"B").start();
        new Thread(()->{window.saleTicket();},"C").start();
    }
}
