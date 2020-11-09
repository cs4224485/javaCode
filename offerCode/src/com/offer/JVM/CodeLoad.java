package com.offer.JVM;

import jdk.swing.interop.SwingInterOpUtils;

class CodeZY{
    public CodeZY(){
        System.out.println("Code的构造方法1111");
    }

    {
        System.out.println("Code的构造块2222");
    }
    static {
        System.out.println("Code的静态代码块3333");
    }
}

/***
 * 执行优先级:静态代模块(只执行一次)> 构造代码块> 构造方法
 */
public class CodeLoad {
    {
        System.out.println("CodeBlock03的构造块444");
    }
    static {
        System.out.println("CodeBlock03的静态代码块555");
    }
    public CodeLoad(){
        System.out.println("CodeBlock3的构造方法666");
    }

    public static void main(String[] args) {
        System.out.println("分割线———————— main方法的777");
        new CodeZY();
        System.out.println("----------------");
        new CodeZY();
        System.out.println("------------------");
        new CodeLoad();
    }
}
