package com.harry.datastructure.huffmantree;

import com.sun.applet2.AppletParameters;

import java.io.*;
import java.util.*;

public class HuffmanCodeDemon {
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
//        String s = "i like like like java do you like a java";
//        byte[] contentBytes = s.getBytes();
//        System.out.println(contentBytes.length);
//        byte[] huffmanzip = huffmanzip(contentBytes);
//        System.out.println("压缩后的长度"+ huffmanzip.length);
//        byte[] decode = decode(huffmanCodes, huffmanzip);
//        System.out.println(new String(decode));
        zipFile("D:\\schooladmin.sql","D:\\schooladmin.sql.zip");
        System.out.println("压缩成功");
        unZipFile("D:\\schooladmin.sql.zip", "D:\\schooladmin.sql2");
    }

    //编写方法，将一个文件进行压缩
    /**
     *
     * @param srcFile 你传入的希望压缩的文件的全路径
     * @param dstFile 我们压缩后将压缩文件放到哪个目录
     */
    public static void zipFile(String srcFile, String dstFile){
        // 创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        // 创建文件的输入流
        FileInputStream is = null;
        try {
            // 创建文件的输入流
            is = new FileInputStream(srcFile);
            // 创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            // 读取文件
            is.read(b);
            // 直接对源文件压缩
            byte[] huffmanBytes = huffmanzip(b);
            // 创建文件的输出流， 存放到压缩文件
            os = new FileOutputStream(dstFile);
            // 创建一个和文件输出流关联的objectOutputStream
            oos = new ObjectOutputStream(os);
            // 把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            // 这里我们以对象流的方式写入赫夫曼编码，是为了以后我们恢复源文件时使用
            // 注意一定要把赫夫曼编码写入压缩文件
            oos.writeObject(huffmanCodes);

        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (os != null) {
                    os.close();
                }
            }catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }

    }

    /**
     *
     * @param zipFile 准备解压的文件
     * @param dstFile 将文件解压到哪个路径
     */
    public static void unZipFile(String zipFile, String dstFile){
        //定义文件输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;
        try {
            // 创建文件输入流
            is = new FileInputStream(zipFile);
            // 创建一个和is关联的对象输入流
            ois = new ObjectInputStream(is);
            // 读取byte数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            // 读取赫夫曼码表
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            // 解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            // 将bytes数组写入到目标文件
            os = new FileOutputStream(dstFile);
            // 写数据到desFile
            os.write(bytes);
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (Exception e2) {
                // TODO: handle exception
                System.out.println(e2.getMessage());
            }
        }
    }

    public static  List<Node2> getNode(byte[] contentBytes){
        HashMap<Byte, Integer> countMap  = new HashMap<>();

        for (byte s2: contentBytes) {
            Integer count = countMap.get(s2);
            if (count == null){
                countMap.put(s2, 1);
            }else {
                countMap.put(s2,count+1);
            }
        }
        List<Node2> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : countMap.entrySet()) {
            Node2 node = new Node2(entry.getKey(), entry.getValue());
            nodes.add(node);
        }
        return nodes;
    }
    //使用一个方法，将前面的方法封装起来，便于调用

    /***
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 经过Huffman编码处理后的字节数组
     */
    public static byte[] huffmanzip(byte[] bytes){
        // 得到nodes
        List<Node2> nodes = getNode(bytes);
        // 创建Huffman树
        Node2 huffmanTree = createHuffmanTree(nodes);
        //        huffmanTree.infixOrder();
        // 创建赫夫曼编码
        Map<Byte, String> huffmanCode = getCodes(huffmanTree);
        System.out.println(huffmanCode);
        // huffman编码后的bytes

        // 进行压缩
        byte[] huffmanCodeBytes = zip(bytes, huffmanCode);
        System.out.println("huffmanCodeBytes" + Arrays.toString(huffmanCodeBytes));
        return huffmanCodeBytes;

    }
    private static Node2 createHuffmanTree(List<Node2> nodes){
        while (nodes.size() > 1){
            Collections.sort(nodes);
            Node2 leftNode = nodes.get(0);
            Node2 rightNode = nodes.get(1);

            Node2 parent = new Node2(null, leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.add(parent);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }
        return nodes.get(0);
    }
    // 编写一个方法，将字符串对应byte[]数组通过生成的赫夫曼编码标返回一个赫夫曼编码压缩后的byte[]

    /***
     *
     *
     * @param bytes 这是原始的字符串对应的byte[]
     * @param huffmanCodes 生成的赫夫曼编码的map
     * @return 返回赫夫曼编码处理后的byte[]
     * 举例      String s = "i like like like java do you like a java" >>byte[] contentBytes = s.getBytes();
     * 返回的是“i like like like java do you like a java” 对应的byte[]数组
     * huffmanCodeBytes[0] = 10101000(补码) => byte[推导 10101000 => 10100111(反码) => 11011000 = -88]
     *
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes){
        // 1. 利用 huffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历bytes数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println(stringBuilder);
        // 将“101010001011111100...” 转成byte[]
        int len;
        // 也可以写成一句话 int len = (stringBuilder.length() +7) /8;
        if (stringBuilder.length() % 8 == 0){
            len = stringBuilder.length() /8;
        }else {
            len = stringBuilder.length() /8 +1;
        }
        // 创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0; //记录是第几个byte
        for (int i=0; i<stringBuilder.length(); i += 8){
            // 因为是每8位对应一个byte， 所以是步长加8
            String strByte;
            if (i +8 > stringBuilder.length()){
                // 不够8为了
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i, i+8);
            }
            // 将styByte转成一个byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }
    private static Map<Byte, String> getCodes(Node2 root){
        if (root == null){
            return null;
        }
        // 处理左子树
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }
    /**
     * 功能： 将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes集合
     * @param node 传入结点
     * @param code 路径： 左子结点是 0, 右子结点 1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node2 node, String code, StringBuilder stringBuilder){
        System.out.println(stringBuilder);
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        // 将code加入到stringBuilder2
        stringBuilder2.append(code);
        if (node != null){
            // 如果node ==null 不处理
            // 判断当前node是叶子节点还是非叶子节点
            if (node.data == null){
                // 非叶子节点
                // 递归处理
                // 向左递归
                getCodes(node.left, "0", stringBuilder2);
                // 向右递归
                getCodes(node.right, "1", stringBuilder2);
            }else{
                // 说明是一个叶子节点。;
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }

        }
    }

    /***
     * 将一个byte转成一个二进制的字符串，如果不懂参考二进制的源码，反码补码
     * @param b 传入的 byte
     * @param flag 标志是否需要补高位如果是 true ，表示需要补高位，如果是 false 表示不补, 如果是最后一个字节，无需补高位
     * @return 是该 b 对应的二进制的字符串，（注意是按补码返回
     */
    public static String byteTobitString(boolean flag, byte b){
        // 使用变量保存 b
        int temp = b; // 将b转成int
        // 如果是正数我们还存在补高位
        if (flag){
            temp |= 256; // 1 0000 0000 | 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp); // 返回的是tempp对应的二进制补码
        if (flag){
            return str.substring(str.length()-8);
        }else{
            return str;
        }

    }
    //编写一个方法，完成对压缩数据的解码
    /**
     *
     * @param huffmanCodes 赫夫曼编码表 map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes) {
        // 1. 先得到huffmanBytes对应的二进制的字符串，形式101010001011.....
        StringBuilder stringBuilder = new StringBuilder();
        // 将byte数组转成二进制的字符串
        for (int i = 0; i <huffmanBytes.length ; i++) {
            byte b = huffmanBytes[i];
            // 判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length -1);
            stringBuilder.append(byteTobitString(!flag, b));
        }
        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte, String> byteStringEntry : huffmanCodes.entrySet()) {
            map.put(byteStringEntry.getValue(), byteStringEntry.getKey());
        }
        // 创建集合 存放byte
        List<Byte> list = new ArrayList<>();
        // i可以理解成就是索引，扫描stringBuilder
        for (int i = 0; i < stringBuilder.length();){
            int count = 1; // 小的计数器
            boolean flag = true;
            Byte b = null;

            while (flag){
                //1010100010111...
                //递增的取出 key 1
                String key = stringBuilder.substring(i, i+count);//i 不动，让 count 移动，指定匹配到一个字符
                b = map.get(key);
                if(b == null) {//说明没有匹配到
                    count++;
                }else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i+= count; // i 直接移动到count
        }
        // 放for循环后 我们list中就存放了所有的字符 "i like like like java do you like a java"
        // 把list中的数据放入到byte[] 并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i <b.length ; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

}
class Node2 implements Comparable<Node2>{
    int value; // 节点权值
    Node2 left;
    Node2 right;
    Byte data;

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


    public Node2(Byte data , int value) {
        this.data = data;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [Data="+ data+":"+"value=" + value + "]";
    }
    @Override
    public int compareTo(Node2 o) {
        return this.value - o.value;
    }
}