package com.example.newcoder;

public class uniquePaths {
    public int uniquePaths (int m, int n) {
        // write code here
        int arr[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    arr[0][j] = 1;
                    continue;
                }
                if (j == 0) {
                    arr[i][0] = 1;
                    continue;
                }
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}
