package com.harry1024.observer.impl;

import com.harry1024.observer.Observer;

public class ObserverA implements Observer {
    @Override
    public void handleNotify(String message){
        System.out.println("路人甲正在观察");
    }
}
