package com.harry.datastructure.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        // 要求将数组进行升序排序
        int arr[] = {4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void heapSort(int[] arr){
        int temp = 0;
        System.out.println("堆排序");
//        adjustHeap(arr, 1 ,arr.length);
//        System.out.println("第一次" + Arrays.toString(arr)); // 4, 9, 8, 5, 6
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第 2 次" + Arrays.toString(arr)); // 9,6,8,5,4
        // 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i= arr.length/2 -1; i >=0; i-- ){
            System.out.println("树顶" + arr[i]);
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length-1; j >0 ; j--) {
            // j 相当于数组最后一个元素， 要与第一个元素最交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            System.out.println("length" +j);
            adjustHeap(arr, 0, j);
        }

    }
    // 将一个数组(二叉树)调整成一个大顶推
    /**
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例 int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用 adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素的值，保存在临时变量(子树顶部的值)
        int temp = arr[i];
        for (int k = i * 2+1; k <length ; k = k*2+1) {
            System.out.println(arr[k] + ":" +k);
            //说明左子结点的值小于右子结点的值
            if (k + 1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
                //如果子结点大于父结点
                arr[i] = arr[k];//把较大的值赋给当前结点
                i = k; // !! i指向k,继续循环比较
            }else {
                break; // ! 重要
            }

        }
        //当for循环结束后， 我们已经将以i为父节点的树的最大值，放在了最顶(局部)
        arr[i] = temp; // 将temp值放置调整后的位置
    }
}
