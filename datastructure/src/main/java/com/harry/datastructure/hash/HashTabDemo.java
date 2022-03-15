package com.harry.datastructure.hash;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// 创建HashTab管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListsArray;
    private int size; // 表示有多少条链表

    public HashTab(int size){
        this.size = size;
        empLinkedListsArray = new EmpLinkedList[size];
        // 初始化每个链表
        for (int i = 0; i <size ; i++) {
            empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    public void add (Emp emp){
        // 根据员工的id，得到该员工应该添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        // 将emp添加到对应的链表中
        empLinkedListsArray[empLinkedListNO].add(emp);
    }

    // 遍历所有链表，遍历hashtab
    public void list(){
        for (int i = 0; i <size ; i++) {
            empLinkedListsArray[i].list(i);
        }
    }

    // 根据输入的id，查找雇员
    public void findEmpById(int id){
        // 使用散列函数确定到哪条链表查找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListsArray[empLinkedListNo].findEmpById(id);
        if (emp != null){
            System.out.printf("在第%d 条链表中找到 雇员 id = %d\n", (empLinkedListNo  + 1), id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }

    }
    public int hashFun(int id){
        return id % size;
    }
}

// 创建EmpLinkedList 表示链表
class EmpLinkedList{
    // 头指针。指向第一个Emp，因此我们这个链表的head是直接指向第一个Emp
    private Emp head; // 默认null

    // 添加雇员到链表
    //1. 假定当添加雇员时，id是自增长，即id的分配总是从小到大，因此我们将雇员直接加入到本链表的最后即可
    public void add(Emp emp){
        // 如果是添加第一个雇员
        if (head == null){
            head = emp;
            return;
        }
        Emp temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // 退出时直接将emp加入链表
        temp.next = emp;
    }

    // 遍历链表的雇员信息
    public void list(int no){
        if (head == null){
            System.out.println("第 "+(no+1)+" 链表为空");
            return;
        }
        System.out.print("第 "+(no+1)+" 链表的信息为");
        Emp curEmp = head; // 辅助指针
        while (true){
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
    // 根据id查找雇员
    // 如果查找到就返回Emp 如果没有找到就返回null
    public Emp findEmpById(int d){
        // 判断链表是否为空
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id == d){
                break; // 找到， 这时curEmp就要指向要查找的雇员
            }
            if (curEmp.next == null){
                // 说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}