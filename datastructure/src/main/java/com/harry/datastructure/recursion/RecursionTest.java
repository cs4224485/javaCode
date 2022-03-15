package com.harry.datastructure.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //通过打印问题，回顾递归调用机制
        test(4);
        int res = factorial(5);
        System.out.println("res" + res);
    }
    public static void test(int n){
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);


    }
    public static int factorial(int n){
        if (n == 1){
         return 1;
        }
        int res = factorial(n -1) * n;
        System.out.println("factorial:"+ res);
        return res;
    }
}
