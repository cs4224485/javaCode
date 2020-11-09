package com.harry.springCloud.service;

import java.util.List;

import com.harry.springCloud.entity.Dept;

public interface DeptService {
	  public boolean add(Dept dept);
	  public Dept    get(Long id);
	  public List<Dept> list();
}

