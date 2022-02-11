package com.harry.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

@Slf4j(topic = "c.test")
public class TestSchedule {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        // 获得当前时间
        LocalDateTime now = LocalDateTime.now();
        // 获取本周四 18:00:00.000
        LocalDateTime thursday =
                now.with(DayOfWeek.THURSDAY).withHour(18).withMinute(0).withSecond(0).withNano(0);
        // 如果当前时间已经超过 本周四 18:00:00.000， 那么找下周四 18:00:00.000
        if(now.compareTo(thursday) >= 0) {
            thursday = thursday.plusWeeks(1);
        }
        // 计算时间差，即延时执行时间
        long initialDelay = Duration.between(now, thursday).toMillis();
        // 计算间隔时间，即 1 周的毫秒值
        long oneWeek = 7 * 24 * 3600 * 1000;
        System.out.println("开始时间：" + new Date());
        executor.scheduleAtFixedRate(() -> {
            System.out.println("执行时间：" + new Date());
        }, initialDelay, oneWeek, TimeUnit.MILLISECONDS);
    }
    @Test
    public void test1(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        // 添加两个任务，希望它们都在 1s 后执行
        System.out.println("start....");
        executor.schedule(() -> {
            System.out.println("任务1，执行时间：" + new Date());
            try { Thread.sleep(2000); } catch (InterruptedException e) { }
        }, 1000, TimeUnit.MILLISECONDS);
        executor.schedule(() -> {
            System.out.println("任务2，执行时间：" + new Date());
        }, 1000, TimeUnit.MILLISECONDS);

    }
    @Test
    public void test(){
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        log.debug("start....");
        pool.scheduleAtFixedRate(() ->{
            log.debug("running");
        },1,1, TimeUnit.SECONDS);

    }


}

