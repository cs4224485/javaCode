package com.harry.thread;

public class Singleton2 {
    private Singleton2(){

    }
    private static volatile Singleton2 INSTANCE = null;
    public static Singleton2 getInstance(){
        if (INSTANCE == null){
            // 首次访问会同步，而之后的使用没有synchronized
            synchronized (Singleton2.class){
                if (INSTANCE == null){
                    INSTANCE  = new Singleton2();
                }
            }
        }
        return INSTANCE;
    }
}
