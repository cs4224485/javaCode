package com.offer.letcode;

public class TowSum01 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 16};
        int target = 18;
        int [] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (target - nums[j] == nums[i]){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        System.out.println(result[0]);
        System.out.println(result[1]);

    }
}
