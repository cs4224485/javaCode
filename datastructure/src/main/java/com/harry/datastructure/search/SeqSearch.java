package com.harry.datastructure.search;

public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};// 没有顺序的数组
        int index = seqSearch(arr, 9);
        if (index == -1) {
            System.out.println("没有找到到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }

    public static int seqSearch(int[] arr, int findValue){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == findValue){
                return i;
            }
        }
        return -1;
    }
}
