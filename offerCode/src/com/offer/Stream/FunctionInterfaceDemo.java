package com.offer.Stream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        // 消费型函数式接口  参数类型:T     返回类型void    对类型为T的对象应用操作, 包含方法:void accept(T t)
        Consumer<String> consumerDemo = s -> {
            System.out.println("消费型函数式接口");
        };
        consumerDemo.accept("test");
        // 供给型函数式接口  参数类型:无    返回类型T   返回类型为T的对象，包含方法：T get();
        Supplier<String> supplierDemo = () -> {return "供给型函数接口";};
        System.out.println(supplierDemo.get());
        // 函数形接口        参数类型:T     返回类型:R   对类型为T的对象应用操作，并返回结果。 结果是R类型的对象。包含方法:R apply(T t)
        Function<String,Integer> functionDemon = s ->{return s.length();};
        System.out.println(functionDemon.apply("ssdf"));
        // 断定型接口        参数类型:T      返回类型:boolean    确定类型为T的对象是否满足某约束，并返回boolean值。 包含方法boolean test(T t)
        Predicate<String> predicateDemon = s -> {return s.isEmpty();};
        System.out.println(predicateDemon.test("sdf"));
    }
}
