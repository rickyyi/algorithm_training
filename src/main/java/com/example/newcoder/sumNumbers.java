package com.example.newcoder;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 二叉树根节点到叶子节点的所有路径和
 * https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83
 */
public class sumNumbers {

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

    int sum = 0;

    public int sumNumbers (TreeNode root) {
        // write code here
        int t = root.val;
        if (root.left == null && root.right == null) {

        }



        return 1;

    }

    public int sumNumbers (TreeNode node, int sum) {



        return 1;

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


    }

}
