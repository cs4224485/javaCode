package com.harry.thread.produce;

import com.harry.thread.Downloader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
@Slf4j(topic = "c.produce")
public class TestProduce {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(2);
        for (int i = 0; i <4 ; i++) {
            int id = i;
            new Thread(()->{
                try {
                    log.debug("download...");
                    List<String> response = null;
                    response = Downloader.download();
                    log.debug("try put message({})", id);
                    messageQueue.put(new Message(id, response));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            },"生产者"+i).start();
        }

        new Thread(()->{
            while (true){
                Message message = messageQueue.take();
                List<String> response = (List<String>) message.getMessage();
                log.debug("take message({}): [{}] lines", message.getId(), response.size());
            }
        }, "消费者").start();
    }
}
