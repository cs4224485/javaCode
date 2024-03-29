package com.harry.decorator;

public class CoffeeBar {
    public static void main(String[] args) {
        // 装饰者模式下的订单：2 份巧克力+一份牛奶的 LongBlack
        // 1. 点一份 LongBlack
        Drink order = new LongBlack();
        System.out.println("费用1=" + order.cost());
        System.out.println("描述=" + order.getDes());
        // 2. order 加入一份牛奶
        order = new Milk(order);
        System.out.println("order 加入一份牛奶 费用 =" + order.cost());
        System.out.println("order 加入一份牛奶 描述 = " + order.getDes());
        // 3. order 加入一份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入一份牛奶 加入一份巧克力 费用 =" + order.cost());
        order = new Chocolate(order);
        System.out.println("order 加入一份牛奶 加入 2 份巧克力 费用 =" + order.cost());
        System.out.println("order 加入一份牛奶 加入 2 份巧克力 描述 = " + order.getDes());
    }
}
