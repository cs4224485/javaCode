package com.harry1024.observer;

import com.harry1024.observer.impl.ObserverA;
import com.harry1024.observer.impl.ObserverB;
import com.harry1024.observer.impl.ToBeObserverA;

/**
 * 观察者模式测试
 */

public class Test {
    public static void main(String[] args) {
        // 创建被观察者对象
        ToBeObserver toBeObserverA = new ToBeObserverA();
        // 创建观察者对象
        Observer a = new ObserverA();
        Observer b = new ObserverB();
        // 向被观察者中添加被观察者
        toBeObserverA.addObserver(a);
        toBeObserverA.addObserver(b);
        // 被观察者向观察者发送通知
        toBeObserverA.notifyObserver("摔倒了");
    }
}
