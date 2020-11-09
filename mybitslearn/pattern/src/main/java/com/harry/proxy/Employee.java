package com.harry.proxy;

public class Employee {
    law lawer;

    public Employee(law lawer) {
        this.lawer = lawer;
    }

    public void forMoney() {
        lawer.goToCourt();
    }
}
