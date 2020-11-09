package com.harry.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public Department selectById(Integer id){
        String SQL = "SELECT * FROM department where id = ?";
        BeanPropertyRowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
        Department department = jdbcTemplate.queryForObject(SQL, rowMapper, id);
        return department;
    }
}
