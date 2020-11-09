package com.offer.JUC;

interface Bar{
    void sayHello();
}
@FunctionalInterface
interface Foo{
    int add(int x, int y);

    default int div(int x, int y){
        return x/y;
    }
}

/**
 * Lambda表达式 口诀： 拷贝小括号，写死右箭头， 落地大括号
 * @FunctionalInterface:函数式接口，里面可以写方法 default关键字修饰
 */
public class LambdaExpress {
    public static void main(String[] args) {
        Bar bar = () -> {
            System.out.println("Hello World");
        };
        bar.sayHello();
        Foo foo = (int x, int y) ->{
            return 10 + 5;
        };
        int result = foo.add(10, 5);
        System.out.println(result);
    }
}
