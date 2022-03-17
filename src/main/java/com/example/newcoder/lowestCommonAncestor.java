package com.example.newcoder;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * NC102 在二叉树中找到两个节点的最近公共祖先
 * https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116
 */
public class lowestCommonAncestor {

    
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(root.val, Integer.MAX_VALUE);

        while (!map.containsKey(o1) || !map.containsKey(o2)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                map.put(node.left.val, node.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                map.put(node.right.val, node.val);
            }
        }

        List<Integer> set = new LinkedList<>();
        while (map.containsKey(o1)) {
            Integer v = map.get(o1);
            set.add(v);
            o1 = v;
        }

        for (Integer v : set) {

        }

        return 0;
    }
    
    public void search(TreeNode root, int target, LinkedList<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        if (root.val == target) {
            return;
        }
        search(root.left, target, set);
        search(root.right, target, set);
        set.removeLast();
    }

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

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);

        TreeNode treeNode11 = new TreeNode(11, treeNode2, treeNode7);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode11);
        TreeNode treeNode8 = new TreeNode(8, null, treeNode9);
        TreeNode root = new TreeNode(5, treeNode4, treeNode8);

        LinkedList<Integer> linkedList = new LinkedList<>();
        new lowestCommonAncestor().lowestCommonAncestor(root, 7, 5);
        System.out.println(linkedList);
    }
    
}
