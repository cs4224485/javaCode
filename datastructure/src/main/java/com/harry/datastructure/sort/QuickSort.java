package com.harry.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};
//
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data2Str = format.format(date2);
        System.out.println("排序前的时间是=" + data2Str);

    }

    public static void quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        while (l < r){
            while (arr[l] < pivot){
                l++;
            }

            while (arr[r] > pivot){
                r--;
            }
            if (l >= r){
                break;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 如果交换完成后 发现这个arr[l] == pivot值 相等， r-- 前移
            if (arr[l] == pivot){
                r-=1;
            }
            // 如果交换玩后 发现这个arr[r] == pivot值 相等， l++ 前移
            // 左边移动到右边了 右边移动到了左边
            if (arr[r] == pivot){
                l+=1;
            }


        }
        if (l == r){
            l++;
            r--;
        }
        if (l < right){
            quickSort(arr,l,right);
        }
        if (r > left ){
            quickSort(arr,left, r);
        }
    }
}
