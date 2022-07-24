package com.harry.proxy;

public class TeacherDaoProxy implements ITeacherDao{

    // 目标对象 通过接口来聚合
    private ITeacherDao target;


    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理 完成某些操作。。。。。 ");//方法
        target.teach();
        System.out.println("提交。。。。。");//方法
    }
}
