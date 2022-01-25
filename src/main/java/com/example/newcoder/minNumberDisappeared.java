package com.example.newcoder;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/50ec6a5b0e4e45348544348278cdcee5
 */
public class minNumberDisappeared {

    public int minNumberDisappeared (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        // write code here
        Arrays.sort(nums);
        int min = 1;
        for (int num : nums) {
            if (num < 0) {
                continue;
            }
            if (num == min) {
                min = min + 1;
            }
        }
        if (min <= 0) {
            min = 1;
        }
        return min;
    }

    public static void main(String[] args) {
        //new minNumberDisappeared().minNumberDisappeared(new int[]{1,0,2});
        //new minNumberDisappeared().minNumberDisappeared(new int[]{-2,3,4,1,5});
        new minNumberDisappeared().minNumberDisappeared(new int[]{4,5,6,7,8,9});
    }
}
