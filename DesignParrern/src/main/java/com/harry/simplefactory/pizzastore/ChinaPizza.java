package com.harry.simplefactory.pizzastore;

public class ChinaPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("China披萨准备中");
    }

    @Override
    public void bake() {
        System.out.println("China披萨烘烤中 ");
    }

    @Override
    public void cut() {
        System.out.println("China披萨切割中");
    }

    @Override
    public void box() {
        System.out.println("China披萨打包中");
    }
}
