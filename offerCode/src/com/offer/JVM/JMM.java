package com.offer.JVM;


class MyNumber{
    volatile int number = 10;
    public void  addTo1205(){
        this.number = 1205;
    }
}

public class JMM {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "*****come in");
            // 暂停一会儿线程
            try {
                Thread.sleep(3000);
                myNumber.addTo1205();
                System.out.println(Thread.currentThread().getName()+"\t update number, number value"+ myNumber.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
        while (myNumber.number == 10){

            // 需要一种通知机制告诉main线程， number已经修改为1205 跳出while

        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }
}
