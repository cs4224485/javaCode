package com.harry1024.observer;

public interface Observer {
    /**
     * 在接收到通知之后做出的响应处理
     * @param message
     */
    public void handleNotify(String message);

}
