package com.harry.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergetSort {
    public static void main(String[] args) {
//        int[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
//        int[] temp = new int[arr.length]; //归并排序需要一个额外空间

        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        int[] temp = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data2Str = format.format(date2);
        System.out.println("排序前的时间是=" + data2Str);

        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right) / 2; // 中间索引
            mergeSort(arr, left, mid, temp); // 向左递归分解
            mergeSort(arr,mid+1, right,temp); // 向右递归分解
            // 合并
            merge(arr, left,mid, right, temp);
        }
    }
    // 合并的方法
    /***
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int l = left;
        int r = mid+1;
        int t = 0;
        while (l<=mid && r <=right){
            if (arr[l] < arr[r]){
                temp[t] = arr[l];
                l++;
                t++;
            }else {
                temp[t] = arr[r];
                r++;
                t++;
            }
        }

        while (l <= mid){
            temp[t] = arr[l];
            t++;
            l++;
        }
        while (r <= right){
            temp[t] = arr[r];
            r++;
            t++;
        }

        int tempLeft = left;
        t = 0;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
