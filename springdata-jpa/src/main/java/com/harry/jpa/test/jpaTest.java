package com.harry.jpa.test;

import com.harry.jpa.bean.Customer;
import com.harry.jpa.utill.JPAUtil;
import org.junit.Test;


import javax.persistence.*;
import java.util.List;

public class jpaTest {
    @Test
    public void testAdd() {
        /**
         * 创建实体管理类工厂，借助Persistence的静态方法获取
         * 		其中传递的参数为持久化单元名称，需要jpa配置文件中指定
         */
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = new Customer();
        customer.setCustName("蔡爽");
        entityManager.persist(customer);
        transaction.commit();
        entityManager.close();
        factory.close();
    }

    @Test
    public void testSave() {
        // 定义对象
        Customer c = new Customer();
        c.setCustName("CS");
        c.setCustLevel("VIP客户");
        c.setCustSource("网络");
        c.setCustIndustry("IT教育");
        c.setCustAddress("昌平区北七家镇");
        c.setCustPhone("010-84389340");
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            // 获取实体管理对象
            em = JPAUtil.getEntityManager();
            // 获取事务对象
            tx = em.getTransaction();
            // 开启事务
            tx.begin();
            // 执行操作
            em.persist(c);
            // 提交事务
            tx.commit();
        } catch (Exception e) {
            // 回滚事务
            tx.rollback();
            e.printStackTrace();
        } finally {
            // 释放资源
            em.close();
        }
    }

    @Test
    public void testMerge() {
        //定义对象
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            //获取实体管理对象
            em = JPAUtil.getEntityManager();
            //获取事务对象
            tx = em.getTransaction();
            //开启事务
            tx.begin();
            //执行操作
            Customer c1 = em.find(Customer.class, 6L);
            c1.setCustName("江苏传智学院");
            em.clear();//把c1对象从缓存中清除出去
            em.merge(c1);
            //提交事务
            tx.commit();
        } catch (Exception e) {
            //回滚事务
            tx.rollback();
            e.printStackTrace();
        } finally {
            //释放资源
            em.close();
        }
    }

    @Test
    public void testRemove() {
        // 定义对象
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            // 获取实体管理对象
            em = JPAUtil.getEntityManager();
            // 获取事务对象
            tx = em.getTransaction();
            // 开启事务
            tx.begin();
            // 执行操作
            Customer c1 = em.find(Customer.class, 6L);
            em.remove(c1);
            // 提交事务
            tx.commit();
        } catch (Exception e) {
            // 回滚事务
            tx.rollback();
            e.printStackTrace();
        } finally {
            // 释放资源
            em.close();
        }
    }

    @Test
    public void testGetOne() {
        // 定义对象
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            // 获取实体管理对象
            em = JPAUtil.getEntityManager();
            // 获取事务对象
            tx = em.getTransaction();
            // 开启事务
            tx.begin();
            // 执行操作
            Customer c1 = em.find(Customer.class, 1L);
            // 提交事务
            tx.commit();
            System.out.println(c1); // 输出查询对象
        } catch (Exception e) {
            // 回滚事务
            tx.rollback();
            e.printStackTrace();
        } finally {
            // 释放资源
            em.close();
        }
    }

    @Test
    public void findAll() {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            //获取实体管理对象
            em = JPAUtil.getEntityManager();
            //获取事务对象
            tx = em.getTransaction();
            tx.begin();
            // 创建query对象
            String jpql = "from Customer";
            Query query = em.createQuery(jpql);
            // 查询并得到返回结果
            List list = query.getResultList(); // 得到集合返回类型
            for (Object object : list) {
                System.out.println(object);
            }
            tx.commit();
        } catch (Exception e) {
            // 回滚事务
            tx.rollback();
            e.printStackTrace();
        } finally {
            // 释放资源
            em.close();
        }
    }

    @Test
    public void findPaged() {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            //获取实体管理对象
            em = JPAUtil.getEntityManager();
            //获取事务对象
            tx = em.getTransaction();
            tx.begin();
            // 创建query
            String jpql = " from Customer";

        } catch (Exception e) {
            // 回滚事务
            tx.rollback();
            e.printStackTrace();
        } finally {
            // 释放资源
            em.close();
        }
    }

    //根据客户id倒序查询所有客户
    //查询所有客户
    @Test
    public void testOrder() {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            //获取实体管理对象
            em = JPAUtil.getEntityManager();
            //获取事务对象
            tx = em.getTransaction();
            tx.begin();
            // 创建query对象
            String jpql = "from Customer order by custId desc";
            Query query = em.createQuery(jpql);
            // 查询并得到返回结果
            List list = query.getResultList(); // 得到集合返回类型
            for (Object object : list) {
                System.out.println(object);
            }
            tx.commit();
        } catch (Exception e) {
            // 回滚事务
            tx.rollback();
            e.printStackTrace();
        } finally {
            // 释放资源
            em.close();
        }
    }
    //统计查询
    @Test
    public void findCount() {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            //获取实体管理对象
            em = JPAUtil.getEntityManager();
            //获取事务对象
            tx = em.getTransaction();
            tx.begin();
            // 查询全部客户
            // 1.创建query对象
            String jpql = "select count(custId) from Customer";
            Query query = em.createQuery(jpql);
            // 2.查询并得到返回结果
            Object count = query.getSingleResult(); // 得到集合返回类型
            System.out.println(count);
            tx.commit();
        } catch (Exception e) {
            // 回滚事务
            tx.rollback();
            e.printStackTrace();
        } finally {
            // 释放资源
            em.close();
        }
    }

}