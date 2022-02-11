package com.harry.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

@Slf4j(topic = "c.test1")
public class TestForkjoin extends RecursiveTask<Integer> {
    @Override
    protected Integer compute() {
        return null;
    }
}
