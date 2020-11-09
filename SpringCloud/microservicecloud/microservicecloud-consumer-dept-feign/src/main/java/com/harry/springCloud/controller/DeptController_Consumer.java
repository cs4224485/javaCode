package com.harry.springCloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harry.springCloud.entity.Dept;
import com.harry.springCloud.service.DeptClientService;

@RestController
public class DeptController_Consumer
{
	@Autowired
	private DeptClientService service = null;
    
    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
         return service.add(dept);
    }
    
    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
         return service.getDept(id);
    }
    

    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
         return service.list();
    }   
}