package com.harry.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, 20};
//        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
        //为了容量理解，我们把冒泡排序的演变过程，给大家展示
        //测试一下冒泡排序的速度 O(n^2), 给 80000 个数据，测试
        //创建要给 80000 个的随机的数组
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        bubbleSort(arr);

        Date date2 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data2Str = format.format(date2);
        System.out.println("排序前的时间是=" + data2Str);
        //运行结果
//        排序前的时间是=2022-03-01 19:25:30
//        排序前的时间是=2022-03-01 19:25:41
    }

    public static void bubbleSort(int[] array){
        // 冒泡排序 的时间复杂度 O(n^2), 自己写出
        boolean flag = false;
        for (int i = 0; i <array.length - 1 ; i++) {
            for (int j = 0; j < array.length -1 - i; j++) {
                int temp = array[j];
                // 如果前面的数比后面的数大，则交换
                if (array[j] > array[j+1]){
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }

            }
            if(!flag){
                // 在一趟排序中，一次交换都没有发生过
                break;
            }else {
                // 重置 flag!!!, 进行下次判断
                flag = false;
            }
        }
    }
}
