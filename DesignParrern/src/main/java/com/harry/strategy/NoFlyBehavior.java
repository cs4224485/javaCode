package com.harry.strategy;

public class NoFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println(" 不会飞翔 ");
    }
}
