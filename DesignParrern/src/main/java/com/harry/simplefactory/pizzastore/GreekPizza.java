package com.harry.simplefactory.pizzastore;

public class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println( getName() + "披萨准备中");
    }

    @Override
    public void bake() {
        System.out.println(getName() + "披萨烘烤中 ");
    }

    @Override
    public void cut() {
        System.out.println(getName() + "Greek披萨切割中");
    }

    @Override
    public void box() {
        System.out.println(getName() + "Greek披萨打包中");
    }
}
