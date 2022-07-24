package com.harry.iterator;

import java.util.Iterator;

public class ComputerCollegeIterator implements Iterator<Department> {

    // 这里我们需要 Department 是以怎样的方式存放=>数组
    Department[] departments;
    int position = 0; //遍历的位置

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
       if (position >= departments.length || departments[position] == null){
           return false;
       }else{
           return true;
       }
    }

    @Override
    public Department next() {
        Department department = departments[position];
        position +=1;
        return department;
    }

    //删除的方法，默认空实现
    @Override
    public void remove() {
    }
}
