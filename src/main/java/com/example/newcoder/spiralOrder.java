package com.example.newcoder;

import java.util.ArrayList;

public class spiralOrder {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }
        int[] row0 = matrix[0];
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = row0.length - 1;
        while (top < (matrix.length + 1)/2 && left < (row0.length+1) / 2) {
            for (int i = left; i <= right; i++) {
                System.out.println(matrix[top][i]);
                result.add(matrix[top][i]);
            }
            for (int i = top+1; i <= bottom; i++) {
                System.out.println(matrix[i][right]);
                result.add(matrix[i][right]);
            }
            for (int i = right - 1; i >= left && right!=left; i--) {
                System.out.println(matrix[bottom][i]);
                result.add(matrix[bottom][i]);
            }
            for (int i = bottom - 1; i >= top+1 && top!=bottom; i--) {
                System.out.println(matrix[i][left]);
                result.add(matrix[i][left]);
            }
            ++ left ;
            -- right ;
            ++top ;
            --bottom ;
        }

        return result;
    }

    public static void main(String[] args) {
        /*int[] row0 = new int[]{1,2,3,4};
        int[] row1 = new int[]{5,6,7,8};
        int[] row2 = new int[]{9,10,11,12};
        int[] row3 = new int[]{13,14,15,16};

        int[][] matrix = new int[4][4];
        matrix[0] = row0;
        matrix[1] = row1;
        matrix[2] = row2;
        matrix[3] = row3;*/
        int[] row0 = new int[]{2,3};
        int[][] matrix = new int[1][2];
        matrix[0] = row0;
        new spiralOrder().spiralOrder(matrix);
    }
}
