package juc;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * 生产者消费者 阻塞队列
 * 使用：volatile CAS atomicInteger BlockQueue 线程交互 原子印用
 */
class MyResource{
    // 默认开启 进行生产消费
    // 这里用到了Volatitle为了保持数据可见性，也就是TLAG修改时，需马上通知其他线程进行修改
    private volatile boolean FLAG = true;
    // 使用原子包装类 而不使用number++
    private AtomicInteger atomicInteger = new AtomicInteger();
    // 这里不能为了满足条件 而实例化一个具体的SynchronousBlockingQueue
    BlockingQueue<String> blockingQueue = null;
    // 采用依赖注入里面的，构造注入方法传入
    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        // 查询出传入的class是什么
        System.out.println(blockingQueue.getClass().getName());
    }

    /***
     * 生产
     */
    public void myProd() throws InterruptedException {
        String data = null;
        boolean retValue;
        // 多线程环境的判断 一定要使用while进行 防止出现虚假唤醒
        // 当FLAG为true的时候开始生产
        while (FLAG){
            data = atomicInteger.incrementAndGet() +"";
            // 2秒存入1个data
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue){
                System.out.println(Thread.currentThread().getName() + "\t 插入队列:" + data  + "成功" );
            }else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列:" + data  + "失败" );
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产，表示FLAG=false，生产介绍");
    }
    /***
     * 消费
     *
     */
    public void myConsumer() throws InterruptedException {
        String retValue;
        // 多线程环境的判断，一定要使用while进行 防止出现虚假唤醒
        while(FLAG) {
            // 2秒存入1个data
            retValue = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(retValue != null && retValue != "") {
                System.out.println(Thread.currentThread().getName() + "\t 消费队列:" + retValue  + "成功" );
            } else {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 消费失败，队列中已为空，退出" );

                // 退出消费队列
                return;
            }
        }
    }
    /**
     * 停止生产的判断
     */
    public void stop() {
        this.FLAG = false;
    }
}
public class ProdConsumerBlockingQueueDemo {
    public static void main(String[] args) {
        // 传入具体的实现类， ArrayBlockingQueue
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            System.out.println("");
            System.out.println("");
            try {
                myResource.myProd();
                System.out.println("");
                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");

            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        // 5秒后，停止生产和消费
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("");
        System.out.println("5秒中后，生产和消费线程停止，线程结束");
        myResource.stop();
    }
}
