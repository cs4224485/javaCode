package basic;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Condtional {

    public static final Lock myLock = new ReentrantLock();
    public static volatile Boolean A = false;
    public static volatile Boolean b = false;
    public static volatile Boolean c = false;
    public static void main(String[] args) {
        Condition conditionA = myLock.newCondition();
        Condition conditionB = myLock.newCondition();
        Condition conditionC = myLock.newCondition();


        new Thread(()->{
            try{
                myLock.lock();
                while (!A) {
                    conditionA.await();
                }
                System.out.println("A");
                b = true;
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                myLock.unlock();;
            }

        },"A").start();

        new Thread(()->{

            try {
                myLock.lock();
                while(!b){
                    conditionB.await();
                    System.out.println(Thread.currentThread().getName());
                }
                c = true;
                conditionC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                myLock.unlock();
            }

        },"B").start();
        new Thread(()->{
            try {
                myLock.lock();
                while(!c){
                    conditionC.await();
                    System.out.println(Thread.currentThread().getName());
                }
                A = true;
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                myLock.unlock();
            }

        },"C").start();
        try {
            myLock.lock();
            A = true;
            conditionA.signal();
        }finally{
            myLock.unlock();
        }

    }
}
