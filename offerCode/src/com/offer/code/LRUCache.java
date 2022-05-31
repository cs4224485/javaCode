package com.offer.code;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends  LinkedHashMap<K,V>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCacheDemo = new LRUCache(3);
        lruCacheDemo .put(1, "a");
        lruCacheDemo .put(2, "b");
        lruCacheDemo .put(3, "c");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(4,"d");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5,"x");
        System.out.println(lruCacheDemo.keySet());

    }

}
