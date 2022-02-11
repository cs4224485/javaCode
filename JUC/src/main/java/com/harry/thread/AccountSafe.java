package com.harry.thread;

public class AccountSafe implements  Account2{

    private Integer balance;
    public AccountSafe(Integer balance) {
        this.balance = balance;
    }
    @Override
    public Integer getBalance() {
        return balance;
    }

    @Override
    public void withdraw(Integer amount) {

    }
}
