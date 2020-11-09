package com.harry.springboot;

import com.harry.springboot.bean.Article;

import com.harry.springboot.bean.Book;
import com.harry.springboot.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void dataAdd(){
        Book book = new Book();
		book.setId(1);
		book.setBookName("西游记");
		book.setAuthor("吴承恩");
		bookRepository.index(book);

    }

    // 测试搜索
    @Test
    public void search(){
        for (Book book : bookRepository.findByBookNameLike("游")) {
            System.out.println(book);
        }
    }
}
