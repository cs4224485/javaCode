package com.harry.servlet.util;

import com.harry.servlet.bean.Book;

import java.util.HashMap;
import java.util.Map;

public class DBUtil {

    private static Map<String, Book> books = new HashMap<String, Book>();

    static {
        books.put("1", new Book("1", "java快速入门", 20, "马化腾"));
        books.put("2", new Book("2", "java进阶之路", 30, "李彦宏"));
        books.put("3", new Book("3", "java高手速成", 40, "马云"));
        books.put("4", new Book("4", "java编程之道", 50, "雷军"));
    }

    //取得全部图书
    public static Map<String, Book> findAllBooks() {
        return books;
    }

    /**
     * 根据id查找指定的书
     *
     * @param id
     * @return
     */
    public static Book findBookById(String id) {
        return books.get(id);
    }
}
