package com.harry1024.observer;

/**
 * 被观察者
 */
public interface ToBeObserver {
    /**
     * 添加观察者
     */
    public void addObserver(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * 通知观察者
     * @param message
     */
    public void notifyObserver(String message);
}
