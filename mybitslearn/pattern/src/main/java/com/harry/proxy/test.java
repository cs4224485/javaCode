package com.harry.proxy;

public class test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        ProxyLawer lawer = new ProxyLawer(boss);
        Employee ep = new Employee(lawer);
        ep.forMoney();
    }
}
