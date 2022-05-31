package com.offer.letcode;

import java.util.HashMap;

public class TowSum02 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,16};
        int target = 18;
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
