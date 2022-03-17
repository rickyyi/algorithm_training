package com.example.newcoder;

public class MaxSubArr {

    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        int max = array[0];
        dp[0] = array[0];
        for(int i=1;i<array.length;i++){
            // 动态规划，状态转移方程，确定dp[i]的最大值
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            System.out.println(i + " : " + dp[i]);
            // 每次比较，保存出现的最大值
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new MaxSubArr().FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5});
        System.out.println(i);
    }
}
