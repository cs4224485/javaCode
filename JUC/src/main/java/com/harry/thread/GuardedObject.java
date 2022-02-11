package com.harry.thread;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

public class GuardedObject {
    private Object response;

    private final Object lock = new Object();

    public Object get(){
        synchronized (lock){
            // 条件不满足则等待
            while (response == null){
                try {
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (lock) {
            // 条件满足，通知等待线程
            this.response = response;
            lock.notifyAll();
        }
    }

}
@Slf4j(topic = "c.test")
class Test{
    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
        new Thread(()->{
            // 子线程执行下载
            try {
                List<String> response = Downloader.download();
                log.debug("download complete");
                guardedObject.complete(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        log.debug("waiting");
        // 主线程阻塞等待
        Object response = guardedObject.get();
        log.debug("get response:[{}] lines", ((List<String>) response).size());
    }
}