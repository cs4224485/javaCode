package com.offer.code;

public class TestStep {
    // 实现f(n):求n步台阶，一共有几种走法
    public int f(int n){
        if (n<1){
            throw new IllegalArgumentException(n + "不能小于1");
        }
        if(n==1 || n==2){
            return n;
        }
        return f(n-2) + f(n-1);
    }
}
