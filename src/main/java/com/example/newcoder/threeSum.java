package com.example.newcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/345e2ed5f81d4017bbb8cc6055b0b711
 * 数组先排序
 * 固定第一个数，双指针首位便利
 */
public class threeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num == null || num.length < 3) {
            return result;
        }
        Arrays.sort(num);
        if (num[num.length - 1] < 0) {
            return result;
        }
        for (int i = 0; i < num.length - 2; i++) {
            int vi = num[i];

            int j = i + 1;
            int k = num.length - 1;

            while (j < k) {
                if (vi + num[j] + num[k] > 0) {
                    k --;
                } else if (vi + num[j] + num[k] < 0) {
                    j ++;
                } else {
                    ArrayList<Integer> r = new ArrayList<>();
                    r.add(vi);
                    r.add(num[j]);
                    r.add(num[k]);

                    result.add(r);
                    while (j+1 < k && num[j+1] == num[j] ) {
                        j ++;
                    }
                    while (j < k-1 && num[k-1] == num[k] ) {
                        k ++;
                    }
                    j ++;
                    k --;
                }
            }
            while (i+1 < num.length -1 && num[i+1] == vi) {
                i++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new threeSum().threeSum(new int[]{});
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer + "; ");
            }
            System.out.println();
        }
    }
}
