package com.harry.simplefactory.pizzastore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    // 定义一个简单工厂对象
    SimpleFactory simplefactory;
    Pizza pizza = null;
    public OrderPizza(SimpleFactory simplefactory){
        setFactory(simplefactory);
    }

    public void  setFactory(SimpleFactory simplefactory){
        String orderType = "";
        this.simplefactory = simplefactory;
        do {
            orderType = getType();
            pizza = this.simplefactory.createPizza(orderType);
            // 输出pizza
            if (pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println(" 订购披萨失败 ");
                break;
            }
        }while(true);
    }

    // 写一个方法，可以获取客户希望订购的披萨种类
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        OrderPizza orderPizza = new OrderPizza(new SimpleFactory());

    }
}
