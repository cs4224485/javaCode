package com.harry.springboot.service;

import com.harry.springboot.bean.Employee;
import com.harry.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    RedisTemplate redisTemplate; //操作k-v都是字符串的

    @Autowired
    StringRedisTemplate stringRedisTemplate; //k-v都是对象的

    /**
     *Reis常见的五大数据类型
     * String(字符串),List(列表),Set(集合),Hash(散列),ZSet(有序集合)
     * stringRedisTemplate.opsForValue()[String（字符串）]
     * StringRedisTemplate.opsForList()[List]
     * StringRedisTemplate.opsForSet()[Set]
     * StringRedisTemplate.opsForHash()[Hash]
     * StringRedisTemplate.opsForZSet()[ZSet]
     *
     */
    @Cacheable(value = {"emp"}, key = "#id")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    @CachePut(value = {"emp"},key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp:"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    public void deleteEmp(Integer id){
        System.out.println("deleteEmp:"+id);
        //employeeMapper.deleteEmpById(id);
        int i = 10/0;
    }

    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }


}
