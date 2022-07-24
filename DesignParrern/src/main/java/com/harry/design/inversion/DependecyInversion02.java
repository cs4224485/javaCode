package com.harry.design.inversion;

public class DependecyInversion02 {
    public static void main(String[] args) {
//客户端无需改变
        Person2 person = new Person2();
        person.receive(new Email2());
        person.receive(new WeiXin());
    }
}

//定义接口
interface IReceiver {
    public String getInfo();
}
class Email2 implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}
//增加微信
class WeiXin implements IReceiver {
    @Override
    public String getInfo() {
        return "微信信息: hello,ok";
    }
}
//方式 2
class Person2 {
    //这里我们是对接口的依赖
    public void receive(IReceiver receiver ) {
        System.out.println(receiver.getInfo());
    }
}