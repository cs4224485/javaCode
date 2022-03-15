package com.harry.datastructure.tree;

import com.sun.deploy.ui.AboutDialog;

public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能

        ThreadBinaryTree.HeroNode2 root = new ThreadBinaryTree.HeroNode2(1, "tom");
        ThreadBinaryTree.HeroNode2 node2 = new ThreadBinaryTree.HeroNode2(3, "jack");
        ThreadBinaryTree.HeroNode2 node3 = new ThreadBinaryTree.HeroNode2(6, "smith");
        ThreadBinaryTree.HeroNode2 node4 = new ThreadBinaryTree.HeroNode2(8, "mary");
        ThreadBinaryTree.HeroNode2 node5 = new ThreadBinaryTree.HeroNode2(10, "king");
        ThreadBinaryTree.HeroNode2 node6 = new ThreadBinaryTree.HeroNode2(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);
        threadBinaryTree.threadedNodes(root);

        //测试: 以 10 号节点测试
        ThreadBinaryTree.HeroNode2 leftNode = node5.getLeft();
        ThreadBinaryTree.HeroNode2 rightNode = node5.getRight();
        System.out.println("10 号结点的前驱结点是 =" + leftNode); //3
        System.out.println("10 号结点的后继结点是=" + rightNode); //1

        //当线索化二叉树后，能在使用原来的遍历方法
        //threadedBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        threadBinaryTree.threadList(); // 8, 3, 10, 1, 14, 6
    }


}

class ThreadBinaryTree{
    private HeroNode2 root;

    // 为了实现线索化，需要创建要给指向当前节点的前驱节点的指针
    // 在递归进行线索化时，pre总是保留一个节点
    private HeroNode2 pre = null;


    public void setRoot(HeroNode2 root){
        this.root = root;
    }
    // 遍历线索化二叉树的方法
    public void threadList(){
        // 定义一个变量，存储当前遍历的节点，从root开始
        HeroNode2 node = root;
        while (node != null){
            // 循环的找到leftType ==1的节点，第一个找到就是8节点
            // 后面随着遍历而变化，因为当leftType==1时，说明该节点是按照线索化
            // 处理后的有序节点
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }

            // 打印当前这个节点
            System.out.println(node);
            // 如果当前节点的右指针指向的是后继节点就一直输出
            while (node.getRightType() == 1){
                // 获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            // 替换这个遍历的节点
            node = node.getRight();
        }
    }

    // 编写对二叉树进行中序线索化的方法
    public void threadedNodes(HeroNode2 node){
        // 如果 node ==null 不能线索化
        if (node ==null){
            return;
        }
        // 先线索化左子树
        threadedNodes(node.getLeft());
        // 线索化当前节点
        // 处理当前节点的前驱节点，以8节点来理解， 8的节点的left=null，8节点的leftTye ==1
        if (node.getLeft() == null){
            // 让当前节点的左指针向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }
        // 处理后续节点
        if (pre != null && pre.getRight() == null){
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            pre.setRightType(1);
        }
        // !!! 每处理一个节点后，让当前节点是一个节点的前驱节点
        pre = node;
        // 线索化右子树
        threadedNodes(node.getRight());

    }
    // 删除节点
    public void delNode(int no){
        if (root != null){
            //如果只有一个 root 结点, 这里立即判断 root 是不是就是要删除结点
            if(root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
        }
    }
}

static class HeroNode2{
    private int no;
    private String name;
    private HeroNode2 left;
    private HeroNode2 right;
    // 如果leftType ==0表示指向的是左子树，如果1则表示指向前驱节点
    // 如果rightType ==0表示指向的是右子树，如果1则表示指向前驱节点
    private int leftType;
    private int rightType;
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }
    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    // 递归删除节点
    // 如果删除的节点是叶子节点，则删除该节点
    // 如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no){
        /***
         * 1 因为我们的二叉树是单向的，所以我们是判断当前节点的字节点是否需要删除，而不能去判断当前这个节点是不是需要删除节点
         * 2 如果当前节点的左子节点不为空，并且左子节点就是要删除节点，就将this.left =null，并且就返回(结束递归删除)
         * 3 如果当前节点的右子节点不为空，并且左子节点就是要删除节点，就将this.right =null，并且就返回(结束递归删除)
         * 4 如果第2和第3步没有删除节点，那么我们就需要左子树进行递归删除
         * 5 如果第4步也没有删除节点，则应当向右子树进行递归删除
         */
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }

    }

}


}