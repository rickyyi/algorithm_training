package com.example.leetcode;

import lombok.AllArgsConstructor;

import java.util.*;

public class MergeLinkedList {

    @AllArgsConstructor
    public static class Node {
        int val;
        Node next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(3, new Node(5, null)));
        Node l2 = new Node(1, new Node(2, new Node(4, null)));

        //maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
        LRU(new int[][]{{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}},3);
    }

    public static Node mergeLinkedList (Node l1, Node l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Node pre = new Node(0, null);
        Node p = pre;

        while (l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;;
            if (v2 > v1) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null) {
            p.next = l2;
        }
        if (l2 == null) {
            p.next = l1;
        }
        return pre.next;
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        Queue<Integer> queue = new ArrayDeque<>();

        ArrayList<Integer> rtn = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            if (queue.size() >= size) {
                queue.poll();

                rtn.add(max);
            } else {
                queue.offer(num[i]);
            }
        }
        return rtn;
    }

    @AllArgsConstructor
    public static class LRUNode {
        int key;
        int value;
    }

    public static int[] LRU (int[][] operators, int k) {
        // write code here
        HashMap<Integer, LRUNode> map = new HashMap<>();
        LinkedList<LRUNode> linkedList = new LinkedList<>();
        for (int i = 0; i < operators.length; i++) {
            int[] operator = operators[i];
            System.out.print(operator[0] == 1 ? "set:" : "get:");
            System.out.print(operator[0] == 1 ? operator[1] + "-" + operator[2] : operator[1]);
            System.out.println();
            int key = operator[1];
            LRUNode node = map.get(key);
            if (operator[0] == 1) {
                //set
                LRUNode newNode = new LRUNode(key, operator[2]);
                if (node != null) {
                    linkedList.remove(node);
                    linkedList.addFirst(newNode);
                    map.replace(key, newNode);
                    continue;
                }
                if (map.size() < k) {
                    linkedList.addFirst(newNode);
                } else if (map.size() == k) {
                    LRUNode removeNode = linkedList.removeLast();
                    map.remove(removeNode.key);
                    linkedList.addFirst(newNode);
                }
                map.put(k, newNode);
            } else if (operator[0] == 2) {
                if (node == null) {
                    continue;
                }
                linkedList.remove(node);
                linkedList.addFirst(node);
            }
        }
        return null;
    }
}
