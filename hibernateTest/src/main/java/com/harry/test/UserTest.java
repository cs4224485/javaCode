package com.harry.test;

import com.harry.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class UserTest {
    @Test
    public void testUserAdd(){
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.创建sessionFactory
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        // 4.得到一个Session
        Session session = sessionFactory.openSession();
        // 5.开启事务
        Transaction transaction = session.beginTransaction();
        // 6.执行持久化操作
        User user = new User();
        user.setName("zhangsan");
        user.setAge(21);
        user.setGender("男");
        // 将对象保存到表中
        session.save(user);
        // 7.提交事务
        transaction.commit();
        // 8.关闭资源
        session.close();
        sessionFactory.close();

    }
}
