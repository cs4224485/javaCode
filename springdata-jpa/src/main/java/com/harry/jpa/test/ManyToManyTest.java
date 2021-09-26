package com.harry.jpa.test;

import com.harry.jpa.dao.CustomerDao;
import com.harry.jpa.dao.LinkManDao;
import com.harry.jpa.dao.RoleDao;
import com.harry.jpa.dao.UserDao;
import com.harry.jpa.entity.Customer;
import com.harry.jpa.entity.LinkMan;
import com.harry.jpa.entity.SysRole;
import com.harry.jpa.entity.SysUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Set;


public class ManyToManyTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;
    /**
     * 需求：
     * 	保存用户和角色
     * 要求：
     * 	创建2个用户和3个角色
     * 	让1号用户具有1号和2号角色(双向的)
     * 	让2号用户具有2号和3号角色(双向的)
     *  保存用户和角色
     * 问题：
     *  在保存时，会出现主键重复的错误，因为都是要往中间表中保存数据造成的。
     * 解决办法：
     * 	让任意一方放弃维护关联关系的权利
     */
    @Test
    @Transactional  //开启事务
    @Rollback(false)//设置为不回滚
    public void test1(){
        //创建对象
        SysUser u1 = new SysUser();
        u1.setUserName("用户1");
        SysRole r1 = new SysRole();
        r1.setRoleName("角色1");
        //建立关联关系
        u1.getRoles().add(r1);
        r1.getUsers().add(u1);
        //保存
        roleDao.save(r1);
        userDao.save(u1);
    }




}
