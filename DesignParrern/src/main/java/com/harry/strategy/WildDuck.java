package com.harry.strategy;

public class WildDuck extends Duck {
    //构造器，传入 FlyBehavor 的对象
    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println(" 这是野鸭 ");
    }
}