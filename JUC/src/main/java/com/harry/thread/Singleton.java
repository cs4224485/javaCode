package com.harry.thread;

public class Singleton {
    private Singleton(){

    }
    private static Singleton INSTANCE = null;

    public static synchronized Singleton getInstance(){
        if (INSTANCE != null){
            return INSTANCE;
        }
        INSTANCE = new Singleton();
        return  INSTANCE;
    }
}
