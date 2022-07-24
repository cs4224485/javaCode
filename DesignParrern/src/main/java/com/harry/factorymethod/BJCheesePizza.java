package com.harry.factorymethod;



public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(getName() + "准备中");
    }

    @Override
    public void bake() {
        System.out.println(getName() + "烘烤中");
    }

    @Override
    public void cut() {
        System.out.println(getName() + "切割中");
    }

    @Override
    public void box() {
        System.out.println(getName()+ "打包中");
    }
}
