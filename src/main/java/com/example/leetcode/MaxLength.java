package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxLength {



    public int maxLength (int[] arr) {
        // write code here
        int i=0, j=0;
        Queue<Integer> set = new ArrayDeque<>();
        int max = 1;
        while (j < arr.length) {
            int cur = arr[j];
            while (set.contains(cur)) {
                set.poll();
                i = i + 1;
            }
            set.add(cur);
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxLength().maxLength(new int[]{2,2,3,4,3}));
    }
}
