package com.harry.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookService")
public class BookShopServiceImpl implements BookShopService{
    @Autowired
    BookShopDao bookShopDao;

    // 如果没加事务，那么运行时如果用户余额不足或其他原因导致了异常购买失败，但是库存中的商品仍然会-1。开启事务可解决问题
    @Transactional
    @Override
    public void purchase(String username, String isbn) {
        //1. 获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //2. 更新数的库存
        bookShopDao.updateBookStock(isbn);

        //3. 更新用户余额
        bookShopDao.updateUserAccount(username, price);
    }
}
