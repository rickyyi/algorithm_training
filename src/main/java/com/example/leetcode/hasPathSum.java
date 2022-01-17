package com.example.leetcode;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

public class hasPathSum {

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

    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        return m(root, sum);
    }

    public boolean m(TreeNode root, int sum) {
        if (sum == 0) {
            return true;
        }
        if (root == null) {
            return false;
        }
        int s = sum - root.val;
        return m(root.left, s) || m(root.right, s);
    }


    public int maxPathSum (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        return Math.max(val +  maxPathSum(root.left), val + maxPathSum(root.right));
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rtnList = new ArrayList<>();
        if (pRoot == null) {
            return rtnList;
        }
        boolean flag = true;
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                stack.push(node);
            }
            ArrayList<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode treeNode = stack.pop();
                System.out.println(treeNode.val);
                list.add(treeNode.val);
                if (flag) {
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                    }
                } else {
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                    }
                }
            }
            rtnList.add(list);
            flag = !flag;
        }
        return rtnList;
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSame(pRoot.left, pRoot.right);
    }

    boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if (left.val == right.val && isSame(left.left, left.right) && isSame(right.left, right.right)) {
            return true;
        }
        return false;
    }



    public static void main(String[] args) {

        /*

        *
        5
      4    8
    1  11    9
      2 7

        **/

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);

        TreeNode treeNode11 = new TreeNode(11, treeNode2, treeNode7);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode11);
        TreeNode treeNode8 = new TreeNode(8, null, treeNode9);
        TreeNode root = new TreeNode(5, treeNode4, treeNode8);

        ArrayList<ArrayList<Integer>> print = new hasPathSum().Print(root);
        for (ArrayList<Integer> list : print) {
            for (Integer integer : list) {
                System.out.print(integer + " ;");
            }
            System.out.println();
        }
    }
}
