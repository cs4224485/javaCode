package com.offer.code;

public class binarySearch {
    public static int search(int target, int[] list) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] == target) {
                return mid;
            } else if (list[mid] > target) {
                high = mid - 1;
            } else if (list[mid] < target) {
                low = mid + 1;
            } else {
                System.out.println("未能找到目标");
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] li = {1, 2, 3, 4, 5, 6, 7, 8, 10, 23, 45, 78, 100, 111};
        System.out.println(search( 100, li));
    }
}
