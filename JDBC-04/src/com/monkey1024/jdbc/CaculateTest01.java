package com.monkey1024.jdbc;

import org.junit.Assert;
import org.junit.Test;

/**
 *  junit
 */
public class CaculateTest01 {
    /**
     * 使用junit执行方法时
     * 1. 方法不能有返回值
     * 2. 方法不能有参数
     */
    @org.junit.Test
    public void test1(){
        System.out.println("HA HA HA");
    }
    @Test
    public void test(){
        Caclulate c = new Caclulate();
        // 如果和预期不一样会报错
        Assert.assertEquals(17, c.add(10, 5));
    }
}
