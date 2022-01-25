package com.example.newcoder;

public class 最长回文串 {

    public int getLongestPalindrome (String A) {
        // write code here

        int max = 0;

        for (int i = 0; i < A.length(); i++) {
            isPalindrome(A, i, A.length()-1);
        }
        return 1;
    }

    public boolean isPalindrome(String A, int startIndex, int endIndex) {
        int i = 0, j = A.length() - 1;
        while (startIndex < endIndex) {
            if (A.charAt(i) != A.charAt(j)) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }

    public static void main(String[] args) {
        new 最长回文串().getLongestPalindrome("");
    }
}
