package com.harry.algorithm.binarysearchnorecursion;

public class BinarySearchNoRecur {

    public static void main(String[] args) {
        //测试
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 100);
        System.out.println("index=" + index);//

        int i = binarySearchRecur(arr, 11, 0, arr.length - 1);
        System.out.println("index=" + i);
    }

    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right)/2;
            if (arr[mid] == target){
                return mid;
            }else if (target > arr[mid]){
                left = mid +1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
    public static int binarySearchRecur(int[] arr, int target, int left, int right){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if (target > arr[mid]){
            return binarySearchRecur(arr,target, mid+1, right);
        }else if (target < arr[mid]){
            return binarySearchRecur(arr, target,left,mid-1);
        }else {
            return mid;
        }
    }
}
