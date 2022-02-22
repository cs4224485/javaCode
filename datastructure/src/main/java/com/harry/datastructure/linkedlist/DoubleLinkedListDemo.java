package com.harry.datastructure.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
     // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);

        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.printLink();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.printLink();

        doubleLinkedList.delete(4);
        System.out.println("删除4");
        doubleLinkedList.printLink();
    }
}

// 创建一个双向链表的类
class DoubleLinkedList{
    public HeroNode2 headNode = new HeroNode2(0,"","");

    public void add(HeroNode2 heroNode){
        // 当前链表是空的
        HeroNode2 temp = headNode;
        while (true){
            if (temp.next == null){
                temp.next = heroNode;
                heroNode.prev = temp;
                break;
            }
            temp = temp.next;
        }
    }
    public void update(HeroNode2 heroNode){
        HeroNode2 temp = headNode;
        boolean flag = false;
        while (true){
            if (temp == null){
                // 没有找到
                break;
            }
            if (temp.no == heroNode.no){
                flag = true;
                // 要修改的节点指向了当前temp
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }
    }
    public void  delete(int number){
        if (headNode.next == null){
            System.out.println("链表为空不能删除");
        }
        HeroNode2 temp = headNode;
        while (temp != null){
            System.out.println(temp.no);
            if (temp.no == number){
                // 当前temp 要删除
                if (temp.next == null){
                    System.out.println(temp.prev);
                    temp.prev.next = null;
                }else {
                    temp.next.prev = temp.prev;
                    temp.prev.next = temp.next.next;
                }
                break;
            }
            temp = temp.next;
        }
    }
    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp = headNode;
        boolean flag = false;
        while (true){
            // 插到链表尾部
            if (temp.next == null){
                temp.next = heroNode;
                heroNode.prev = temp;
                break;
            }
            // 插到链表最大数的前面
            if (temp.next.no > heroNode.no){
                heroNode.next = temp.next;
                heroNode.prev = temp;
                temp.next.prev = heroNode;
                temp.next = heroNode;
                break;
            }else if (temp.no == heroNode.no){
                System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
                break;
            }
            temp = temp.next;
        }
    }
    public void printLink(){
        if (headNode.next == null){
            System.out.println("链表为空");
        }
        HeroNode2 tempCurrentNode = headNode.next;
        // 当前节点是最后一个节点
        while (tempCurrentNode != null) {
            System.out.println(tempCurrentNode);
            tempCurrentNode = tempCurrentNode.next;
        }
    }


}

// 定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 prev;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
//                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
