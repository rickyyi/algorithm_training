package com.example.newcoder;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;

public class FindPath {

    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    LinkedList<Integer> hint = new LinkedList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        if (root == null) {
            return result;
        }
        find(root, expectNumber);
        return result;
    }

    public void find(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        hint.add(node.val);
        target = target - node.val;
        if (target == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(hint));
        }
        find(node.left, target);
        find(node.right, target);
        hint.removeLast();
    }
}
