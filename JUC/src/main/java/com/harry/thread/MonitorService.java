package com.harry.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.test1")
public class MonitorService {
    // 用来表示是否已经有线程已经在执行启动了
    private volatile boolean starting;
    public void start() {
        log.info("尝试启动监控线程...");
        synchronized (this) {
            if (starting) {
                return;
            }
            starting = true;
        }

        // 真正启动监控线程...
    }

}
class Test5{
    public static void main(String[] args) {
        MonitorService monitorService = new MonitorService();
        monitorService.start();
    }
}