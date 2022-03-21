package com.harry.datastructure.avl;

public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};
        //int[] arr = { 10, 12, 8, 9, 7, 6 };
        int[] arr = {10, 11, 7, 6, 8, 9 };
        //创建一个 AVLTree 对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for(int i=0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();
        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());// 8
    }
}


// 创建AVLTree
class AVLTree{
    private Node root;
    public Node getRoot(){
        return root;
    }
    public void infixOrder(){
        if (root !=null){
            root.infixOrder();
        }
    }
    public Node search(int value){
        if (root == null){
            return  null;
        }else {
            return root.search(value);
        }
    }
    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }
    // 添加结点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;// 如果 root 为空则直接让 root 指向 node
        } else {
            root.add(node);
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }
    public void add(Node node){
        if (node == null){
            return;
        }
        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }

        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
        //当添加完一个结点后，如果: (右子树的高度-左子树的高度) > 1 , 左旋转
        if (rightHeight() - leftHeight() > 1){
            System.out.println("左旋");
            // 如果他的右子树的左子树的高度大于它的右子树的右子树的高度
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()){
                // 先对右子节点进行右旋转
                this.right.rightRotate();
                //然后在对当前节点进行左旋转
                this.leftRotate();
            }else {
                // 直接进行左旋转即可
                leftRotate();
            }
            return; // 必须要return一下！！
        }
        // 当添加完一个节点后， 如果(左子树的高度-右子树的高度)>1 右旋转
        if (leftHeight() - rightHeight() > 1) {
            System.out.println("右旋" + value);
            if (left != null && this.left.rightHeight() > this.left.leftHeight()){
                // 先对当前节点的左节点（左子树）左旋转
                this.left.leftRotate();
                // 再对当前节点进行右旋转
                this.rightRotate();
            }else {
                this.rightRotate();
            }
        }
    }
    public Node searchParent(int value){
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else {
            // 如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if (value < this.value && this.left !=null){
                return this.left.searchParent(value);
            }else if (value > this.value && this.right != null){
                return this.right.searchParent(value); // 向右子树递归查找
            }else {
                return  null; // 没有找到父节点
            }
        }

    }
    public Node search(int value){
        if (value == this.value){
            return this; // 找到就是该节点
        }else if (value < this.value){
            // 如果查找的值小于当前节点 向左子树递归查找
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    // 返回左子树的高度
    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.height();
    }
    public int rightHeight(){
        if (right == null){
            return 0;
        }
        return right.height();
    }

    public int height(){
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    // 左旋方法
    public void leftRotate(){
        // 创建新的节点，以当前根节点的值
        Node newNode = new Node(value);
        // 把新的节点的左子树设置成当前节点的右子树
        newNode.left = this.left;
        // 把新的节点的右子树设置成带过去节点的右子树的左子树
        newNode.right = this.right.left;
        // 把当前节点的值替换成右子树节点的值
        this.value = this.right.value;
        // 把当前节点的右子树设置成当前节点右子树的右子树
        this.right = this.right.right;
        // 把当前节点的左子树(左子节点)设置成新的节点
        this.left = newNode;
    }
    // 右旋转
    private void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }

    public void infixOrder(){
        if (this.left !=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }
}