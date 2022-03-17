package com.example.newcoder;

/**
 * 插入排序
 */
public class InsertSort {

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {
                int tmp = arr[i - 1];
                if (arr[j] > arr[j - 1]) {

                }
            }
        }

    }

    public void pop(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public void select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
               swap(arr, i, min);
            }
        }
    }

    public void m(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }


    public void swap(int arr[], int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 6, 1, 3, 5};
        new InsertSort().m(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
