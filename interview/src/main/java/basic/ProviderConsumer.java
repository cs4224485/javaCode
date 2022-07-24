package basic;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProviderConsumer {

    public LinkedBlockingQueue<String> linkedBlockingQueue = null;
    private AtomicInteger atomicInteger = new AtomicInteger();
    public ProviderConsumer(int size) {
        this.linkedBlockingQueue = new LinkedBlockingQueue(size);
    }

    public ProviderConsumer() {

    }

    public void provider(){
        String message;
        while(true){
            try {
                message = atomicInteger.incrementAndGet() + "";
                linkedBlockingQueue.put(message);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consumer(){
        String result;
        while(true){
            try {
                result = linkedBlockingQueue.take();
                System.out.println("获取消息:" + result);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ProviderConsumer providerConsumer = new ProviderConsumer(3);
        new Thread(()->{
           providerConsumer.provider();
        }).start();

        new Thread(()->{
            providerConsumer.consumer();
        }).start();
    }
}
