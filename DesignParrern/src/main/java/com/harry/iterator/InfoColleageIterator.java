package com.harry.iterator;

import java.util.Iterator;
import java.util.List;

public class InfoColleageIterator implements Iterator<Department> {
    List<Department> departmentList;
    int index = -1;

    public InfoColleageIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public boolean hasNext() {
        if (index >= departmentList.size()-1){
            return false;
        }
        index +=1;
        return true;
    }

    @Override
    public Department next() {
        return departmentList.get(index);
    }
}
