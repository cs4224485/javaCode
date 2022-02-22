package com.harry.datastructure.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否 ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);// 加入 5 个小孩节点
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1, 2, 5); // 2->4->1->5->3
    }
}
class CircleSingleLinkedList{
    // 创建第一个first节点，当前没有编号
    Boy first = null;

    public void addBoy(int nums){
        // nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums 的值不正确");
            return;
        }
        Boy curBoy = null; // 辅助指针，帮助构建环形链
        for (int i = 1; i <= nums ; i++) {
            Boy boy = new Boy(i);
           if (i ==1){
               first = boy;
               curBoy = first;
           }else {
               curBoy.setNext(boy);
               curBoy = curBoy.getNext();
               curBoy.setNext(first);
           }
        }

    }
    // 遍历当前的环形链表
    public void showBoy(){
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    // 根据用户的输入，计算出小孩出圈的顺序
    /**
     *
     * @param startNo
     * 表示从第几个小孩开始数数
     * @param countNum
     * 表示数几下
     * @param nums
     * 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums){
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 创建辅助指针，帮助完成出圈
        Boy help = first;
        // 说明 helper 指向最后小孩节点
        while (help.getNext() != first) {
            help = help.getNext();
        }
        //小孩报数前，先让 first 和 helper 移动 k -1 次
        for (int i = 0; i < startNo-1 ; i++) {
            first = first.getNext();
            help = help.getNext();
        }
        //当小孩报数时，让 first 和 helper 指针同时 的移动 m - 1 次, 然后出圈
        //这里是一个循环操作，直到圈中只有一个节点

        while (true) {
            if (help == first){
                //说明圈中只有一个节点
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                help = help.getNext();
            }
            //这时 first 指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d 出圈\n", first.getNo());
            first = first.getNext();
            help.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }
}

// 创建一个 Boy 类，表示一个节点
class Boy {
    private int no;// 编号
    private Boy next; // 指向下一个节点,默认 null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}