package basic;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static int[] arr = {10,3, 4, 5, 6,12,33,22,8};


    @Test
    public static void bubbleSort(){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j=0; j<arr.length-1-i; j++){
                int temp = arr[j];
                if (arr[j] > arr[j+1]){
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(arr);
    }

    public static void selectSort(){
        for (int i = 0; i <arr.length; i++) {
            int mixValue = arr[i];
            int mixIndex = i;
            for (int j=i+1; j<arr.length; j++){
                if (mixValue > arr[j]){
                    mixValue = arr[j];
                    mixIndex = j;
                }
            }
            if (mixIndex != i){
                arr[mixIndex] = arr[i];
                arr[i] = mixValue;

            }
        }
    }

    public static void insertSort(){
        for (int i = 1; i <arr.length ; i++) {
            int insertValue = arr[i];
            int insertIndex = i-1;
            while(insertIndex >= 0 && insertValue< arr[insertIndex]){
                arr[insertIndex+1]  = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertValue;
        }
    }

    public static  void shellSort(){

        for (int gap = arr.length/2; gap > 0 ; gap/=2) {
            for (int i = gap; i <arr.length ; i++) {
                int insertValue = arr[i];
                int insertIndex = i;
                if(insertValue < arr[insertIndex-gap]){
                    while (insertIndex -gap >=0 && insertValue< arr[insertIndex-gap]){
                        arr[insertIndex] = arr[insertIndex-gap];
                        insertIndex-=gap;
                    }
                    arr[insertIndex] = insertValue;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(left+right) / 2];
        while(l < r){
            while(arr[l] < pivot){
                l++;
            }
            while(arr[r] > pivot){
                r--;
            }
            if (l >= r){
                break;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot){
                l++;
            }

            if (arr[r] == pivot) {
                r--;
            }
        }
        // 如果 l == r, 必须 l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
       if (left < r){
           quickSort(arr, left, r);
       }

       if (right > l){
           quickSort(arr, l, right);
       }

    }

    public static void main(String[] args) {

        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}
