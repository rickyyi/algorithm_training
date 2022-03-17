package com.example.leetcode;

/**
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 */
public class maxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {
        int tmp;

        int left = Integer.MIN_VALUE;
        int min = values[0] + 0;
        for (int i = 1; i < values.length; i++) {
            left = Math.max(left, values[i] + i);
        }

        return 1;
    }

    public static void main(String[] args) {

    }
}
