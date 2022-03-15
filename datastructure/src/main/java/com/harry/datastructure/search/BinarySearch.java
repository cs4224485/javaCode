package com.harry.datastructure.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89, 1000, 1000, 1000, 1000, 1000, 1234 };
//        int result = binarySearch(arr, 0, arr.length - 1, 10);
//        System.out.println(result);

        List<Integer> integerList = binarySearch2(arr, 0, arr.length - 2, 1000);
        System.out.println(integerList);

    }
    public static int binarySearch(int[] arr, int left, int right, int findValue){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (findValue < midValue){
            // 向左找
            return binarySearch(arr, left,mid-1, findValue);
        }else if (findValue > midValue){
            // 向右找
            return binarySearch(arr, mid+1, right, findValue);
        }else {
            return mid;
        }
    }
    /*
     * 课后思考题： {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
     * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
     *
     * 思路分析
     * 1. 在找到 mid 索引值，不要马上返回
     * 2. 向 mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
     * 3. 向 mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
     * 4. 将 Arraylist 返回
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findValue){
        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) /2;
        int midValue = arr[mid];
        if (findValue < midValue){
            return binarySearch2(arr,left, mid-1, findValue);
        }else if (findValue > midValue){
            return binarySearch2(arr, mid+1, right, findValue);
        }else {
            List<Integer> resIndexlist = new ArrayList<Integer>();
            // * 思路分析
            // * 1. 在找到 mid 索引值，不要马上返回
            // * 2. 向 mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            // * 3. 向 mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            // * 4. 将 Arraylist 返回
            //向 mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            int temp = mid - 1;
            // 退出
            while (temp >= 0 && arr[temp] == findValue) {
                //  就temp放到resIndexList
                resIndexlist.add(temp);
                temp -= 1;
            }
            // 别忘了把找到的mid也加进入进去
            resIndexlist.add(mid);
            temp = mid +1;
            while (temp < arr.length-1 && arr[temp] == findValue){
                resIndexlist.add(temp);
                temp++;
            }
            return resIndexlist;

        }
    }
}
