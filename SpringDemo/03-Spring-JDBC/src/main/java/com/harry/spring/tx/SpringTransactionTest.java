package com.harry.spring.tx;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {


    private ApplicationContext ctx = null;
    @Autowired
    private BookShopDao bookShopDao;
    @Autowired
    private BookShopService bookShopService;
    @Autowired
    private Cashier cashier;
    {
        ctx = new ClassPathXmlApplicationContext("Application.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }
    @Test
    public void testBookShopService(){
        System.out.println();
        bookShopService.purchase("Tom", "0001");
    }

}
