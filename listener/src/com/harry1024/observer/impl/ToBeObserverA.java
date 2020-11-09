package com.harry1024.observer.impl;

import com.harry1024.observer.Observer;
import com.harry1024.observer.ToBeObserver;

import java.util.ArrayList;
import java.util.List;

public class ToBeObserverA implements ToBeObserver {
    // 将观察者放到集合中
    List<Observer> observers;

    public ToBeObserverA() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        for (Observer o : observers) {
            o.handleNotify(message);
        }
    }
}
