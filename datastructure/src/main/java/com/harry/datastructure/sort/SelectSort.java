package com.harry.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int [] arr = {101, 34, 119, 1, -1, 90, 123};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr2[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectSort(arr2);

        Date date2 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data2Str = format.format(date2);
        System.out.println("排序前的时间是=" + data2Str);
//        排序前的时间是=2022-03-01 19:47:13
//        排序前的时间是=2022-03-01 19:47:17
    }
    public static void selectSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;

            }
        }
    }
}
