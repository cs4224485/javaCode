package com.harry.factorymethod;

public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
            pizza.setName("奶酪披萨");
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
            pizza.setName("胡椒披萨");
        }
        return pizza;
    }

    public static void main(String[] args) {
        LDOrderPizza ldOrderPizza = new LDOrderPizza();
        ldOrderPizza.sellPizza();
    }
}
