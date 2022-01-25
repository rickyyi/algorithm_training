package com.example.newcoder;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {

    HashMap<Integer, LRUNode> map;
    LinkedList<LRUNode> linkedList;
    int capacity;

    public static class LRUNode {
        int key;
        int value;

        public LRUNode (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class Node {
        int value;
        Node pre;
        Node next;

        public void remove() {
            Node pre = this.pre;
            Node next = this.next;
            this.next = null;
            pre.next = next;
        }
    }

    public static class Queue {
        Node head;
        Node tail;

        public void addFirst(Node node) {
            if (head == null) {

            }
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.linkedList = new LinkedList<>();
    }

    public int get(int key) {
        LRUNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        linkedList.remove(node);
        linkedList.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        LRUNode node = map.get(key);
        LRUNode newNode = new LRUNode(key, value);
        if (node != null) {
            linkedList.remove(node);
            linkedList.addFirst(newNode);
            map.replace(key, newNode);
            return;
        }
        if (map.size() < this.capacity) {
            linkedList.addFirst(newNode);
        } else if (map.size() == this.capacity) {
            linkedList.removeLast();
            linkedList.addFirst(newNode);
        }
        map.put(key, newNode);
    }
}
