package com.harry.springboot;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    private static String connectString ="192.168.0.128:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;
    private String parentNode = "";
    @Test
    void contextLoads() throws IOException, KeeperException, InterruptedException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 收到事件通知后的回调函数（用户的业务逻辑）
                System.out.println(event.getType() + "--" + event.getPath());

                // 再次启动监听
                try {
                    List<String> children = zkClient.getChildren("/", true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        List<String> children = zkClient.getChildren("/", true);

        for (String child : children) {
            System.out.println(child);
            if (child !=null){
                for (String s : children) {
                    System.out.println(zkClient.getData(parentNode + "/" + child, false, null));
                }
            }

        }



    }

}
