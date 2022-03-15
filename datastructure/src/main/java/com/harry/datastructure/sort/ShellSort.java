package com.harry.datastructure.sort;

public class ShellSort {

    public static void main(String[] args) {

    }
    // 使用逐步推导的方式来编写希尔排序
    // 希尔排序时， 对有序序列在插入时采用交换法,
    // 思路(算法) ===> 代码
    public static void shellSort(int[] arr){
        for (int gap = arr.length/2;  gap >0 ; gap /=2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap组。 每组有length/gap个元素) 补偿gap
                for (int j = 0; j >=0 ; j-=gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j]>arr[j+gap]){
                        int tmp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = tmp;
                    }
                }
            }
        }
    }
    public static void shellSort2(int[] arr){
        for (int gap = arr.length/2;  gap >0 ; gap /= 2) {
            for (int i = gap; i < arr.length ; i++) {
                int insertValue = arr[i];
                int insetIndex = i;
                if (arr[insetIndex] < arr[insetIndex - gap]){
                    while (insetIndex - gap>= 0 && insertValue < arr[insetIndex-gap]){
                        // 移动
                        arr[insetIndex] = arr[insetIndex-gap];
                        insetIndex-=gap;
                    }
                    // 当退出while就给temp找到插入的位置
                    arr[insetIndex] = insertValue;
                }
            }
        }
    }
}
