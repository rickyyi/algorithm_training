package com.example.newcoder;

public class 最长回文串 {

    public int getLongestPalindrome (String A) {
        // write code here
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            int tmpMax = Math.max(isPalindrome(A, i, i), isPalindrome(A, i, i));
            max = Math.max(max, tmpMax);
        }
        return max;
    }

    public int isPalindrome(String A, int startIndex, int endIndex) {
        while (startIndex >= 0 || endIndex < A.length()) {
            if (A.charAt(startIndex) == A.charAt(endIndex)) {
                startIndex --;
                endIndex ++;
            } else {
                break;
            }
        }
        return endIndex - startIndex - 2 + 1;
    }

    public static void main(String[] args) {
        new 最长回文串().getLongestPalindrome("");
    }
}
