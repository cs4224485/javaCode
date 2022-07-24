package com.harry.builder;

public class CommonHouse extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println(" 普通房子打地基 5 米 ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 普通房子砌墙 10cm ");
    }

    @Override
    public void roofed() {
        System.out.println(" 普通房子屋顶 ");
    }
}
