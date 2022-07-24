package com.harry.composite;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class OrganizationComponent {
    private String name; // 名字
    private String des; // 说明

    protected void add(OrganizationComponent organizationComponent) {
        //默认实现
        throw new UnsupportedOperationException();
    }
    protected void remove(OrganizationComponent organizationComponent) {
        //默认实现
        throw new UnsupportedOperationException();
    }

    //方法 print, 做成抽象的, 子类都需要实现
    protected abstract void print();

}
