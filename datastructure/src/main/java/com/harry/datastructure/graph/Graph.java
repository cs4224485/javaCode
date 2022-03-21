package com.harry.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList; // 存储顶点集合
    private int[][] edges; // 存储图对应的邻结矩阵
    private int numOfEdges; // 表示边的数目
    // 定义给数组boolean[] 记录某个节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        // 测试图是不是创建OK
        int n = 8; // 节点的个数
//        String Vertexs[] = {"A", "B", "C", "D", "E"};
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        // 创建图对象
        Graph graph = new Graph(n);
        // 循环的添加顶点
        for(String vertex: Vertexs) {
            graph.insertVertex(vertex);
        }
         //添加边
         //A-B A-C B-C B-D B-E
//         graph.insertEdge(0, 1, 1); // A-B
//         graph.insertEdge(0, 2, 1); // A-C
//         graph.insertEdge(1, 2, 1); // B-C
//         graph.insertEdge(1, 3, 1); // B-D
//         graph.insertEdge(1, 4, 1); // B-E


         //更新边的关系
         graph.insertEdge(0, 1, 1);
         graph.insertEdge(0, 2, 1);
         graph.insertEdge(1, 3, 1);
         graph.insertEdge(1, 4, 1);
         graph.insertEdge(3, 7, 1);
         graph.insertEdge(4, 7, 1);
         graph.insertEdge(2, 5, 1);
         graph.insertEdge(2, 6, 1);
         graph.insertEdge(5, 6, 1);

        //显示一把邻结矩阵
        graph.showGraph();
        //测试一把，我们的 dfs 遍历是否 ok
//        System.out.println("深度遍历");
//        graph.dfs(); // A->B->C->D->E [1->2->4->8->5->3->6->7]
        // System.out.println();
        System.out.println("广度优先!");
        graph.bfs(); // A->B->C->D-E [1->2->3->4->5->6->7->8]
    }
    // 构造器
    public Graph(int n){
        // 初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }


    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /***
     *
     * @param v1 表示点的下标即第几个顶点 “A”-“B” “A”->0 "B"->1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
    // 显示图对应的矩阵
    public void showGraph(){
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
    //i 第一次就是 0
    private void dfs(boolean[] isVisited, int i){
        // 首先我们访问该节点输出
        System.out.print(getValueByIndex(i) + "->");
        // 将节点设置为已访问
        isVisited[i] = true;
        // 查找节点i的第一个邻接节点w
        int w = getFirstNeighbor(i);
        while (w != -1){
            // 说明找到了下一个邻接节点
            if (!isVisited[w]){
                // 如果下一个邻接节点没被访问过， 那么就用这个节点继续递归
                dfs(isVisited, w);
            }
            // 如果w节点已经被访问过。 就继续往下找节点
            w = getNextNeighbor(i, w);
        }
    }
    // 对dfs进行一个重载，遍历我们所有的节点， 并进行dfs
    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i <getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }
    public int getNumOfVertex(){
        return vertexList.size();
    }
    // 根据前一个邻接节点的下标来获取下一个临街节点
    private int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] >0){
                return i;
            }
        }
        return -1;
    }

    // 根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2){
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    private String getValueByIndex(int i){
        return vertexList.get(i);
    }
   // 对一个节点进行广度优先遍历的方法
    public void bfs(boolean[] isVisited, int i){
        int u; // 表示队列的头结点对应下标
        int w; // 邻接节点w
        // 队列。记录结点访问的顺序
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // 访问节点 输出结点信息
        System.out.print(getValueByIndex(i) + "=>");
        // 标记已访问
        isVisited[i] = true;
        // 将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()){
            // 取出队列的头结点下标
            u = queue.removeFirst();
            // 得到第一个邻接节点的下标w
            w = getFirstNeighbor(u);
            while (w != -1){
                // 找到
                // 是否访问过
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "=>");
                    // 标记已经访问
                    isVisited[w] = true;
                    //  入队
                    queue.addLast(w);
                }
                // 以u为前驱节点，找w后面的下一个邻接节点
                w = getNextNeighbor(u, w); // 体现出广度
            }
        }
    }
    //遍历所有的结点，都进行广度优先搜索
    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i <getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }
}
