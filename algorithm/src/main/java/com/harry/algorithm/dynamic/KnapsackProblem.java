package com.harry.algorithm.dynamic;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3}; // 物品的重量
        int[] val = {1500, 3000, 2000}; // 物品的价值 这里val[i] 就是前面讲的v[i]
        int m = 4; // 背包的容量
        int n = val.length; // 物品的个数

        // 创建二维数组
        // v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][]v = new int[n+1][m+1]; // 加1是因为 第一行第一列要设置成0
        // 为了记录放入商品的情况，我们定义一个二维数组
        int[][]path = new int[n+1][m+1];

        //初始化第一行和第一列，这里在本程序中可以不去处理，因为默认就是0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0; //将第一列设置为0
        }
        for (int i = 0; i <v[0].length ; i++) {
            v[0][i] = 0; // 将第一行设置0
        }
        // 根据前面得到公式来动态规划处理
        for (int i = 1; i <v.length ; i++) {
            // 不处理第一行i是从1开始的
            for (int j = 1; j <v[0].length ; j++) {
                // 不处理第一列，j从1开始的
                // 公式
                if (w[i-1] > j){
                    // 因为我们程序i是从1开始的，因此原来公式中的w[i]修改成w[i-1]
                    v[i][j] = v[i-1][j];
                }else {
                    // 因为我们的i从1开始的，因此公式需要调整成 v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]);
                    // 第一次 v[1][1] = max(0,1500)
                    // 为了记录商品存放到背包的情况，我们不能直接使用上面的公式，需要使用if-else来体现公式
                    if (v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        // 把当前的情况记录到path
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }

                }

            }
        }
        // 输出一下v看看目前的情况
        for (int i = 0; i <v.length ; i++) {
            for (int j = 0; j <v[i].length ; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("============================");
        //输出最后我们是放入的哪些商品
        //遍历 path, 这样输出会把所有的放入情况都得到, 其实我们只需要最后的放入

        int row = path.length - 1; // 行的最大下标
        int col = path[0].length - 1;// 列的最大下标

        while (row >0 && col >0){// 从path的最后开始找
            if (path[row][col] == 1){
                System.out.printf("第%d 个商品放入到背包\n", row);
                col -=w[row-1];
            }
            row--;
        }
    }
}
