package com.harry.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AccountUnsafe implements Account2{
    private AtomicInteger balance;

    public AccountUnsafe(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }
    @Override
    public synchronized Integer getBalance() {
        return balance.get();
    }

    @Override
    public synchronized void withdraw(Integer amount) {
        // 需要不断尝试，直到成功为止
        while (true){
            // 比如拿到了旧值 1000
            int prev = balance.get();
            // 在这个基础上 1000-10 = 990
            int next = prev - amount;
            /*
                 compareAndSet 正是做这个检查，在 set 前，先比较 prev 与当前值
                 - 不一致了，next 作废，返回 false 表示失败
                 比如，别的线程已经做了减法，当前值已经被减成了 990
                 那么本线程的这次 990 就作废了，进入 while 下次循环重试
                 - 一致，以 next 设置为新值，返回 true 表示成功
             */
            if (balance.compareAndSet(prev, next)){
                break;
            };
        }
        // 可以简化为下面的方法
        // balance.addAndGet(-1 * amount)
    }
    public static void main(String[] args){
        Account2.demo(new AccountUnsafe(10000));
    }
}
