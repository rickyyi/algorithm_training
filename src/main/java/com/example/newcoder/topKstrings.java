package com.example.newcoder;

import java.util.*;

public class topKstrings {
    /**
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i];
            if (hashMap.containsKey(key)) {
                hashMap.replace(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        TreeMap<String, Integer> map = new TreeMap<>(
                (o1, o2) -> {
                    int r = hashMap.get(o2) - hashMap.get(o1);
                    return r >= 0 ? 1 : -1;
                }
        );

        Set<String> keySet = hashMap.keySet();

        for (String s : keySet) {
            map.put(s, hashMap.get(s));
        }


        String[][] arr = new String[map.size()>k ? k : map.size()][2];
        int i = 0;
        while (i < k && map.size() > 0) {
            Map.Entry<String, Integer> entry = map.pollFirstEntry();
            String[] a = new String[]{entry.getKey(), entry.getValue() + ""};
            arr[i] = a;
            i++;
        }
        return arr;
    }


    public static void main(String[] args) {

        String[] a = new String[]{};

        //"a", "v", "a", "a", "d", "v", "d", "d"
        new topKstrings().topKstrings(a, 2100);


    }
}
