package com.harry.datastructure.search;

public class InsertValueSearch {
    public static void main(String[] args) {
        // int [] arr = new int[100];
        // for(int i = 0; i < 100; i++) {
        // arr[i] = i + 1;
        // }
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int index = insertValueSearch(arr, 0, arr.length - 1, 1234);
        //int index = binarySearch(arr, 0, arr.length, 1);
        System.out.println("index = " + index);
        //System.out.println(Arrays.toString(arr));
    }
    public static  int insertValueSearch(int[] arr, int left, int right, int findValue){
        if (left > right){
            return -1;
        }
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);

        if (findValue < arr[mid]){
            return insertValueSearch(arr, left, mid-1, findValue);
        }else if (findValue > arr[mid]){
            return insertValueSearch(arr, mid+1 , right, findValue);
        }else {
            return mid;
        }
    }
}
