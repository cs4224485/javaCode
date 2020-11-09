package com.harry.spring.service.bean;

public class Car {
    private String name;
    private String production;
    private int price;

    public Car(String name, String production, int price) {
        this.name = name;
        this.production = production;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}
