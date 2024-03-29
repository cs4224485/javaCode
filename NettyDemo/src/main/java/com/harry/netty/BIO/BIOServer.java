package com.harry.netty.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class BIOServer {

    public static void handler(Socket socket){
        try {
            System.out.println("线程信息id = " + Thread.currentThread().getId() + "名字 = " + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            //通过socket获取输入流
            InputStream inputStream = socket.getInputStream();
            //循环的读取客户端发送的数据
            while(true){
                System.out.println("线程信息id = " + Thread.currentThread().getId() + "名字 = " + Thread.currentThread().getName());
                System.out.println("read....");
                int read = inputStream.read(bytes);
                if (read != -1){
                    // 输出客户端发送的数据
                    System.out.println(new String(bytes, 0 , read));
                }else{
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("关闭和client的连接");
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 线程持机制
        // 1. 创建一个线程池
        // 2. 如果有客户端连接，就创建一个线程，与之通讯（单独写一个方法）
        ExecutorService threadPool;
        threadPool = new ThreadPoolExecutor(5, 10, 20, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),  Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");
        while(true){
            System.out.println("线程信息id = " + Thread.currentThread().getId() + "名字 = " + Thread.currentThread().getName());
            //监听，等待客户端连接
            System.out.println("等待连接....");
            // 会阻塞在accept()
            Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            threadPool.execute(()->{
                handler(socket);
            });
        }

    }
}
