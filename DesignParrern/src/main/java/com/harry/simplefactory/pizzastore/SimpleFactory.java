package com.harry.simplefactory.pizzastore;

public class SimpleFactory {

    //根据 orderType 返回对应的 Pizza 对象
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨 ");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" 奶酪披萨 ");
        } else if (orderType.equals("china")) {
            pizza = new ChinaPizza();
            pizza.setName("china");
        }
        return pizza;
    }
}
