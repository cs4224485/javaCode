package com.harry.iterator;

import java.util.Iterator;
import java.util.List;

public class OutPutImpl {

    //学院集合
    List<College> collegeList;
    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    //遍历所有学院,然后调用 printDepartment 输出各个学院的系

    public void printCollege(){
        //从 collegeList 取出所有学院, Java 中的 List 已经实现 Iterator
        Iterator<College> iterator = collegeList.iterator();

        while(iterator.hasNext()){
            College college = iterator.next();
            System.out.println("=== "+college.getName() +"=====" );
            printDepartment(college.createIterator()); //得到对应迭代器
        }
    }
    public void  printDepartment(Iterator<Department> iterator){
        while(iterator.hasNext()){
            Department department = iterator.next();
            System.out.println(department.getName());
        }
    }
}
