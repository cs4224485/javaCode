package com.offer.code;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap();
        hashMap.put("harry", 24);
        hashMap.put("jerry", 34);
        hashMap.put("sam", 54);
        hashMap.put("harry", 34);
        hashMap.forEach((key, value)->{
            System.out.println(key+":" +value);
        });
    }
}
