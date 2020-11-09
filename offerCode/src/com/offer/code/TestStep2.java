package com.offer.code;

public class TestStep2 {
    public int loop(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(n + "不能小于1");
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int one = 2; // 走到第二级台阶的走法
        int two = 1; // 走到第一级台阶的走法
        int sum = 0;
        // 最后跨2步 + 最后跨1步的走法
        for (int i = 3; i < n; i++) {
            // 最后跨2步 + 最后跨一步的走法
            sum = two + one;
            two = one;
            one = sum;

        }
        return sum;
    }
}
