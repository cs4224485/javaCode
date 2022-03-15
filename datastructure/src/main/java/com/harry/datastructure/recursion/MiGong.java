package com.harry.datastructure.recursion;

public class MiGong {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 使用 1 表示墙
        // 上下全部置为 1
        for (int i = 0; i <8 ; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int i = 1; i < 6 ; i++) {
            map[0][i] = 1;
            map[map.length -1][i] = 1;
        }
        // 设置挡板, 1 表示
        map[3][1] = 1;
        map[3][2] = 1;
        // 假设路被堵死
//        map[1][2] = 1;
//        map[2][2] = 1;
        //输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");}
            System.out.println();
        }

        //使用递归回溯给小球找路
//        boolean result = setWay(map, 1, 1);
        boolean result = setWay2(map, 1, 1);
        System.out.println("result:" + result);
        //输出新的地图, 小球走过，并标识过的递归
        System.out.println("小球走过，并标识过的 地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    //说明
        //1. map 表示地图
        //2. x,y 表示从地图的哪个位置开始出发 (1,1)
        //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
        //4. 约定： 当 map[i][j] 为 0 表示该点没有走过 当为 1 表示墙 ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
        //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回
    public static boolean setWay(int[][] map, int x, int y){
        if (map[6][5]==2){
            // 通路已经找到 ok
            return true;
        }else {
            if (map[x][y] == 0){
                // 如果当前这个点还没有走过按照策略 下->右->上->左 走
                map[x][y] = 2; // 假定该点可以走通
                if (setWay(map,x+1, y)){
                    // 往下走
                    return true;
                }else if (setWay(map, x, y+1)){
                    // 往右走
                    return true;
                }else if (setWay(map, x-1, y)){
                    // 往上走
                    return  true;
                }else if (setWay(map, x, y-1)){
                    return true;
                }else {
                    //说明该点是走不通，是死路
                    map[x][y] = 3;
                    return false;
                }
            }else {
                // 如果 map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }

    //修改找路的策略，改成 上->右->下->左
    public static boolean setWay2(int[][] map, int x, int y){
        if (map[6][5]==2){
            // 通路已经找到 ok
            return true;
        }else {
            if (map[x][y] == 0){
                map[x][y] = 2; // 假定该点可以走通
                if (setWay2(map,x-1, y)){
                    // 往上走
                    return true;
                }else if (setWay2(map, x, y+1)){
                    // 往右走
                    return true;
                }else if (setWay2(map, x+1, y)){
                     // 下
                    return  true;
                }else if (setWay2(map, x, y-1)){
                    // 左
                    return true;
                }else {
                    //说明该点是走不通，是死路
                    map[x][y] = 3;
                    return false;
                }
            }else {
                // 如果 map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }

}
