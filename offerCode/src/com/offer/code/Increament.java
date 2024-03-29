package com.offer.code;

public class Increament {
    public static void main(String[] args) {
        /***
         * 总结， 1. 赋值=，最后计算
         *       2. =右边的从左到右加载值依次压入操作数栈
         *       3. 实际先算哪个看运算符优先级
         *       4. 自增自减操作都是直接修改变量的值，不经过操作数栈
         *       5. 最后赋值之前，临时结果也是存储再操作数栈中
         * @param args
         */

        int i = 1;
        i = i++; // 先压栈 再++， 第一步先把i的值压入操作数栈，第二部i变量自增1，第三步把操作数栈中(栈中的值此时是1)的值赋值给i 最终i=1
        int j = i++; // 过程同上但是i自增之后赋值给了j 最终结果j=1 i=2(因为i自增了并且没有赋值所以是2)
        // 1. 先把i的值压入操作数栈(数栈i=2),
        // 2. i变量自增1，
        // 3. ++i把i的值压入操作数栈(数栈i=3),
        // 4.i++把i的值压入操作数栈(数栈i=3)
        // 5.i自增1
        // 6.把操作数栈中前两个弹出求乘积结果再压入栈
        // 7.把操作数栈中的值弹出求和再赋值给k
        int k = i + ++i * i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);
    }
}
