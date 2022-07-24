package com.harry.simplefactory.pizzastore;

public class CheesePizza extends Pizza{



    @Override
    public void prepare() {
        System.out.println("奶酪披萨准备中");
    }

    @Override
    public void bake() {
        System.out.println("奶酪披萨烘烤中 ");
    }

    @Override
    public void cut() {
        System.out.println("奶酪披萨切割中");
    }

    @Override
    public void box() {
        System.out.println("奶酪披萨打包中");
    }
}
