package com.harry.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1, -1, 89};
        // 创建要给 80000 个的随机的数组
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data2Str = format.format(date2);
        System.out.println("排序前的时间是=" + data2Str);

    }

    public static void insertSort(int[] arr){
        for (int i = 1; i <arr.length; i++) {
            int insertValue = arr[i];
            int insetIndex = i-1;
            while (insetIndex >= 0 && insertValue < arr[insetIndex]){
                arr[insetIndex+1] = arr[insetIndex];
                insetIndex--;
            }
            // 如果insetIndex+1 或者i-1没有变化说明不需要交换否则才需要进行交换
            if (insetIndex != i-1 ){
                // 这里其实就是把最小的数插入到了第一个元素
                arr[insetIndex+1] = insertValue;
            }

        }
    }

}
