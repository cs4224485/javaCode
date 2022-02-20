package com.harry.datastructure.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        // 加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        //加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero3);
        singleLinkedList.printLink();

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.printLink();
//        singleLinkedList.delete(2);
//        singleLinkedList.delete(4);
//        singleLinkedList.delete(3);
        singleLinkedList.printLink();
        int length = singleLinkedList.getLength();
//        singleLinkedList.reverseList();
//        singleLinkedList.printLink();
        singleLinkedList.reversePrint();
    }
}


class SingleLinkedList{
    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    HeroNode headNode = new HeroNode(0, "", "");
    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的 next 指向 新的节点
    public void add(HeroNode heroNode) {

        //将最后这个节点的 next 指向 新的节
        HeroNode tempCurrentNode = headNode;
        while (true){
            if (tempCurrentNode.next == null){
                tempCurrentNode.next = heroNode;
                break;
            }
            //如果没有找到最后, 将将 temp 后移
            tempCurrentNode = tempCurrentNode.next;
        }
    }
    public void printLink(){
        if (headNode.next == null){
            System.out.println("链表为空");
        }
        HeroNode tempCurrentNode = headNode.next;
        // 当前节点是最后一个节点
        while (tempCurrentNode != null) {
            System.out.println(tempCurrentNode);
            tempCurrentNode = tempCurrentNode.next;
        }
    }
    public void delete(int no){
        if (headNode.next == null){
            System.out.println("节点为空无法删除");
        }
        HeroNode temp = headNode;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                // 找到了要删除的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断 flag
        if(flag) { //找到
            //可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }
    public void update( HeroNode newHeroNode){
        if (headNode.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = headNode.next;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.no == newHeroNode.no){
                // 找到了开始修改
                flag =true;
                break;
            }
            temp = temp.next;
        }
        // 根据 flag 判断是否找到要修改的节点
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { //没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的 temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = headNode;
        boolean flag = false;
        while (true){
            if (temp.next == null){//说明 temp 已经在链表的最后
                break;
            }
            if (heroNode.no == temp.no){
                System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
                flag = true;
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            }

            temp = temp.next;
        }
        if (!flag){
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    /***
      * @return 返回的就是有效节点的个数
    */
    public int getLength(){
        int count = 0;
        if (headNode.next == null){
            return count;
        }
        HeroNode temp = headNode.next;
        while (temp != null){
            count += 1;
            temp = temp.next;
        }
        return count;
    }
    //查找单链表中的倒数第 k 个结点 【新浪面试题】
    //思路
    //1. 编写一个方法，接收 head 节点，同时接收一个 index
    //2. index 表示是倒数第 index 个节点
    //3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    //4. 得到 size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    //5. 如果找到了，则返回该节点，否则返回 nulll
    public  HeroNode findLastIndexNode(int index){
        if (headNode.next == null){
            System.out.println("空链表");
            return null;
        }
        // 先做一个 index 的校验
        int size = getLength();
        if(index <=0 || index > size) {
            return null;
        }
        HeroNode cur = headNode.next;
        for (int i = 0; i <size -index ; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //将单链表反转
    public  void reverseList() {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(headNode.next == null || headNode.next.next == null) {
            return ;
        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = headNode.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表 reverseHead 的最前端
        while (cur != null){
            next = cur.next; // 先暂时保存当前节点的下一个节点。后面要用
            cur.next = reverseHead.next; // 及那个cur连接到新的链表上
            reverseHead.next = cur;
            cur = next; // 让cur后移
        }
        // 将head.nex指向 reverseHead.next , 实现单链表的反转
        headNode.next = reverseHead.next;
    }
    public void reversePrint(){
        if (headNode.next == null){
            System.out.println("空列表");
        }
        Stack<HeroNode> nodeStack = new Stack<HeroNode>();
        HeroNode cur = headNode.next;
        while (cur != null){
            nodeStack.push(cur);
            cur = cur.next;
        }
        while (!nodeStack.isEmpty()){
            System.out.println(nodeStack.pop());//stack 的特点是先进后出
        }
    }
}

// 定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}