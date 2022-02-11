package com.harry.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import static java.lang.Thread.sleep;

public class Guarded {
    private int id;

    public Guarded(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // 结果
    private Object response;

    // 获取结果
    // timeout 表示要等待多久 2000
    public Object get(long timeout) throws InterruptedException {
        synchronized (this) {
            // 开始时间 15:00:00
            long begin = System.currentTimeMillis();
            // 经历的时间
            long passedTime = 0;
            while (response == null) {
                // 这一轮循环应该等待的时间
                long waitTime = timeout - passedTime;
                // 经历的时间超过了最大等待时间时，退出循环
                if (timeout - passedTime <= 0) {
                    break;
                }
                this.wait(waitTime);
                // 求得经历时间
                passedTime = System.currentTimeMillis() - begin;
            }
            return response;
        }
    }

    // 产生结果
    public void complete(Object response) {
        synchronized (this) {
            // 给结果成员变量赋值
            this.response = response;
            this.notifyAll();
        }
    }

}

class Mailboxes {
    private static Map<Integer, Guarded> boxes = new Hashtable<>();
    private static int id = 1;

    // 产生唯一 id
    private static synchronized int generateId() {
        return id++;
    }

    public static Guarded getGuardedObject(int id) {
        return boxes.remove(id);
    }

    public static Guarded createGuardedObject() {
        Guarded go = new Guarded(generateId());
        boxes.put(go.getId(), go);
        return go;
    }

    public static Set<Integer> getIds() {
        return boxes.keySet();
    }

}

@Slf4j(topic = "c.post")
class Postman extends Thread {
    private int id;
    private String mail;

    public Postman(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void run() {
        Guarded guardedObject = Mailboxes.getGuardedObject(id);
        log.debug("送信 id:{}, 内容:{}", id, mail);
        guardedObject.complete(mail);
    }
}

@Slf4j(topic = "c.people")
class People extends Thread {
    @Override
    public void run() {
        // 收信
        Guarded guardedObject = Mailboxes.createGuardedObject();
        log.debug("开始收信 id:{}", guardedObject.getId());
        Object mail = null;
        try {
            mail = guardedObject.get(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("收到信 id:{}, 内容:{}", guardedObject.getId(), mail);
    }


}

class Test2 {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            new People().start();
        }
        sleep(1000);
        for (Integer id : Mailboxes.getIds()) {
            new Postman(id, "内容" + id).start();
        }
    }

}