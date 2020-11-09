package com.offer.code;

import java.io.IOException;
import java.util.Properties;

public class Singleton3 {
    public static final Singleton3  INSTANCE;
    private String info;
    static {
        Properties properties = new Properties();
        try {
            properties.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        INSTANCE = new Singleton3(properties.getProperty("info"));

    }
    public Singleton3(String info){
        System.out.println(info);
        this.info = info;
    }
}
