package juc;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        // Array  Arrays(辅助工具类)
        // Collection Collections(辅助工具类)
        // Executor Executors(辅助工具类)

        final Integer corePoolSize = 2;
        final Integer maximumPoolSize = 3;
        final Long keepAliveTime = 1L;

        // 一池5个处理线程（用池化技术，一定要记得关闭
        ExecutorService threadPool = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,keepAliveTime,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());

        // 模拟10个用户来办理业务，每个用户就是一个来自外部请求线程
        try {
            // 循环10次， 模拟业务办理。 让5个线程处理这10个请求
            for (int i = 0; i <10 ; i++) {
                final int tempInt = i;
                threadPool.execute(() ->{
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tempInt + " 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
