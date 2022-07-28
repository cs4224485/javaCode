package com.harry.strategy;

import java.util.Arrays;
import java.util.Comparator;

public class Strategy {
    public static void main(String[] args) {

        Integer[] data = { 9, 1, 2, 8, 4, 3 };
        // 实现降序排序，返回-1 放左边，1 放右边，0 保持不变
        // 说明
        // 1. 实现了 Comparator 接口（策略接口） , 匿名类 对象 new Comparator<Integer>(){..}
        // 2. 对象 new Comparator<Integer>(){..} 就是实现了 策略接口 的对象
        // 3. public int compare(Integer o1, Integer o2){} 指定具体的处理方式
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        Arrays.sort(data, comparator);
    }

}
