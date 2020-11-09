package com.harry.proxy;

public class ProxyLawer implements law {
    private Boss boss;

    public ProxyLawer(Boss boss) {
        this.boss = boss;
    }

    public void goToCourt() {
        boss.goToCourt();
    }
}
