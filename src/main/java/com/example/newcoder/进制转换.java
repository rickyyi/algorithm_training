package com.example.newcoder;

import java.util.HashMap;
import java.util.Map;

public class 进制转换 {
    public String solve (int M, int N) {
        // write code here
        boolean f = false;
        if (M < 0) {
            f = true;
            M = -M;
        }

        Map<Integer, String> map = new HashMap<>();
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
        map.put(16, "G");

        StringBuilder sb = new StringBuilder(f ? "-" : "");

        while (M > 0) {
            int a = M % N;
            if (a < 10) {
                sb.insert(0, a);
            } else {
                sb.insert(0, map.get(a));
            }
            M = M / N;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new 进制转换().solve(72, 16);
    }
}
