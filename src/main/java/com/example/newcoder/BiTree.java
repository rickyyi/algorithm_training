package com.example.newcoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BiTree {

    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    public int[][] threeOrders (TreeNode root) {
        List<Integer> l1 = preOrder(root);
        List<Integer> l2 = midOrder(root);
        List<Integer> l3 = postOrder(root);
        int[][] rtn = new int[3][l1.size()];

        int[] r1 = new int[l1.size()];
        for (int i = 0; i < l1.size(); i++) {
            r1[i] = l1.get(i);
        }
        int[] r2 = new int[l1.size()];
        for (int i = 0; i < l2.size(); i++) {
            r2[i] = l2.get(i);
        }
        int[] r3 = new int[l1.size()];
        for (int i = 0; i < l3.size(); i++) {
            r3[i] = l3.get(i);
        }

        rtn[0] = r1;
        rtn[1] = r2;
        rtn[2] = r3;
        return rtn;
    }

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            r.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return r;
    }

    public List<Integer> midOrder(TreeNode root) {
        List<Integer> r1 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (stack.size() > 0 || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                r1.add(node.val);
                cur = node.right;
            }
        }
        return r1;
    }

    public void midOrder(TreeNode root, List<Integer> r1) {
        if (root == null) {
            return;
        }
        midOrder(root.left, r1);
        r1.add(root.val);
        midOrder(root.right, r1);
    }

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            r.add(0, node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return r;
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);

        TreeNode n3 = new TreeNode(3, n1, n2);


        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        TreeNode n6 = new TreeNode(6, n4, n5);


        TreeNode root = new TreeNode(7, n3, n6);

        List<Integer> l1 = new BiTree().preOrder(root);

        for (Integer val : l1) {
            System.out.print(val + " ");
        }

        System.out.println();
        List<Integer> l2 = new BiTree().postOrder(root);

        for (Integer val : l2) {
            System.out.print(val + " ");
        }

        System.out.println();
        List<Integer> l3 = new BiTree().midOrder(root);

        for (Integer val : l3) {
            System.out.print(val + " ");
        }

    }
}
