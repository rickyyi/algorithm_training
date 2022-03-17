package com.example.newcoder;

/**
 * https://www.nowcoder.com/practice/7d21b6be4c6b429bb92d219341c4f8bb
 */
public class minPathSum {

    public int minPathSum (int[][] matrix) {
        // write code here

        int row = matrix.length;
        int col = matrix[0].length;

        int t[][] = new int[col][row];

        t[0][0] = matrix[0][0];

        for (int i = 1; i < col; i++) {
            t[0][i] = matrix[0][i] + t[0][i-1];
        }

        for (int i = 1; i < row; i++) {
            t[i][0] = matrix[i][0] + t[i-1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                t[i][j] = Math.min(t[i-1][j], t[i][j-1]) + matrix[i][j];
            }
        }

        return t[col-1][row-1];
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,3,5,9}, {8,1,3,4}, {5,0,6,1}, {8,8,4,0}};

        int i = new minPathSum().minPathSum(matrix);

        System.out.println(i);
    }
}
