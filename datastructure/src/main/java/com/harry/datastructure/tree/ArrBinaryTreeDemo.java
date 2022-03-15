package com.harry.datastructure.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        //创建一个 ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
//        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
//        arrBinaryTree.infixOrder(0);
        arrBinaryTree.postOrder(0);
    }
}

class ArrBinaryTree{
    private int[] arr; // 存储数据节点的数组

    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }
    /***
     * 编写一个方法，完成顺序存储二叉树的前序遍历
     * @param index
     */
    public void preOrder(int index){
        // 如果数组为空，或者arr.length =0
        if (arr ==null || arr.length ==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        System.out.println(arr[index]);

        // 向左遍历
        if (2*index +1 < arr.length){
            this.preOrder(2*index +1);
        }
        // 向右遍历
        if (index*2 +2 < arr.length){
            this.preOrder(2*index+2);
        }

    }

    public void infixOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        if (index * 2+1 < arr.length){
            this.infixOrder(index*2+1);
        }
        System.out.println(arr[index]);
        if (index*2+2 < arr.length){
            this.infixOrder(index*2+2);
        }
    }

    public void postOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        if (index * 2+1 < arr.length){
            this.postOrder(index*2+1);
        }
        if (index*2+2 < arr.length){
            this.postOrder(index*2+2);
        }
        System.out.println(arr[index]);
    }
}