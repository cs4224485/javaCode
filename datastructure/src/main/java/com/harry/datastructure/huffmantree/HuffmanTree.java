package com.harry.datastructure.huffmantree;

import java.util.*;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
        Node root = createHuffmanTree(arr);
        //测试一把
//        preOrder(root);
//        infixOrder(root);
        postOrder(root);
    }

    // 前序遍历
    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("是空树，不能遍历~");
        }
    }

    public static void infixOrder(Node root){
        if (root != null){
            root.infixOrder();
        }
    }

    public static void postOrder(Node root){
        if (root != null){
            root.postOrder();
        }
    }

    // 创建赫夫曼树
    /***
     * @param arr 需要创建成哈夫曼树的数组
     * @return 创建好后的赫夫曼树的 root 结点
     */
    public static Node createHuffmanTree(int[] arr){
        // 第一步为了操作方便， 1. 遍历arr数组 2. 将arr的每个元素构成成一个Node 3. 将Node放入到ArrayList
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        // 我们处理的过程是一个循环的过程
        while (nodes.size() > 1){
            // 排序从小到大
            Collections.sort(nodes);

//            System.out.println("nodes=" + nodes);
            //取出根节点权值最小的两颗二叉树
            //(1) 取出权值最小的结点（二叉树)
            Node left = nodes.get(0);
            //(2) 取出权值第二小的结点（二叉树）
            Node right = nodes.get(1);
            //(3) 构建一颗新的二叉树
            Node parent = new Node(left.value + right.value);
            parent.setLeft(left);
            parent.setRight(right);
            nodes.add(parent);
            nodes.remove(left);
            nodes.remove(right);

        }
        return nodes.get(0);
    }

}

// 创建节点
// 为了让 Node 对象持续排序 Collections 集合排序
// 让 Node 实现 Comparable 接口
class Node implements Comparable<Node>{
    int value; // 节点权值
    Node left;
    Node right;

    // 前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }

    }
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}