package com.harry.datastructure.binaryTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2, 4};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for(int i = 0; i< arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
//        binarySortTree.infixOrder();

        //测试一下删除叶子结点
//        binarySortTree.delNode(12);
        binarySortTree.delNode(5);
        binarySortTree.delNode(10);
//        binarySortTree.delNode(2);
//        binarySortTree.delNode(3);
        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
        binarySortTree.delNode(7);
        System.out.println("root=" + binarySortTree.getRoot());
        System.out.println("删除结点后");
        binarySortTree.infixOrder();
    }
}

// 创建二叉排序树
class BinarySortTree{
    Node root;

    public Node getRoot() {
        return root;
    }

    public  void add(Node node){
        if (root ==null){
            root = node;
        }else {
            root.add(node);
        }

    }
    public void infixOrder(){
        if (root !=null){
            root.infixOrder();
        }
    }
    // 查找要删除的节点
    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }
    // 查找父节点
    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }
    // 删除节点
    public void delNode(int value){
        if (root == null){
            return;
        }else {
            // 1. 需求先去找到要删除的节点 targetNode
            Node targetNode = search(value);
            // 如果没有找到要删除的节点
            if (targetNode == null){
                return;
            }
            // 如果我们发现当前这颗二叉排序树只有一个节点
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            // 去找到targetNode的父节点
            Node parent = searchParent(value);
            // 如果要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null){
                /***
                 * (1) 需求先去找到要删除的结点 targetNode
                 * (2) 找到 targetNode 的 父结点 parent
                 * (3) 确定 targetNode 是 parent 的左子结点 还是右子结点
                 * (4) 根据前面的情况来对应删除
                 *  左子结点 parent.left = null
                 *  右子结点 parent.right = null;
                 */
                // 判断targetNode是父节点的左子节点，还是右子节点
                if (parent.left != null && parent.left.value == targetNode.value){
                    parent.left = null;
                }else if (parent.right !=null && parent.right.value == targetNode.value){
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right!= null){
                // 删除有两颗子树的节点
                /***
                 *  1) 需求先去找到要删除的结点 targetNode
                 *  2) 找到 targetNode 的 父结点 parent
                 *  3) 从 targetNode 的右子树找到最小的结点
                 *  4) 用一个临时变量，将 最小结点的值保存 temp = 11
                 *  5) 删除该最小结点
                 *  6) targetNode.value = temp
                 */
//                int minVal = delRightTreeMin(targetNode.right);
                int maxVal = delLeftTreeMax(targetNode.left);
                // 把最小节点的值放到当前节点
                targetNode.value = maxVal;
            }else {
                // 删除只有一颗子树的节点
                // 如果要删除的节点有左子节点
                /***
                 * (1) 需求先去找到要删除的结点 targetNode
                 * (2) 找到 targetNode 的 父结点 parent
                 * (3) 确定 targetNode 的子结点是左子结点还是右子结点
                 * (4) targetNode 是 parent 的左子结点还是右子结点
                 * (5) 如果 targetNode 有左子结点
                 */
                if (targetNode.left !=null){

                    if (parent != null){
                        // 如果targetNode 是parent的左子节点
                        if (parent.left != null && parent.left.value == value){
                            //1 如果 targetNode 是 parent 的左子结点  parent.left = targetNode.left;
                            parent.left = targetNode.left;
                        }else {
                            //2 如果 targetNode 是 parent 的右子结点  parent.right = targetNode.left;
                            // targetNode是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                }else {
                    // 如果要删除的结点有右子结点
                    if (parent !=null){
                        if ( parent.left != null &&parent.left.value == value){
                            // targetNode是parent的左子节点
                            parent.left = targetNode.right;
                        }else {
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }

        }
    }
    //1. 返回的以code为根节点的二叉排序树的最小节点的值
    //2. 删除node为根节点的二叉排序树的最小节点

    /***
     *
     * @param node 传入的节点(当做二叉排序树的根节点)
     * @return 返回的以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        // 循环的查找左子节点，就会找到最小值
        while (target.left !=null){
            target = target.left;
        }
        // 这时target就指向了最小节点
        // 删除最小的节点
        delNode(target.value);
        return target.value;
    }

    public int delLeftTreeMax(Node node){
        Node target = node;
        while (target.right != null){
            target = target.right;
        }
        delNode(target.value);
        return target.value;
    }
}

//
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // 查找要删除的节点
    /***
     *
     */
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

    // 查找要删除节点的父节点
    public Node searchParent(int value){
        if ((this.left != null &&this.left.value == value) || (this.right!= null && this.right.value ==value)){
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
    //添加结点的方法
    //递归的形式添加结点，注意需要满足二叉排序树的要求
    public void add(Node node){
        if (node == null){
            return;
        }
        if (node.value < this.value ){
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