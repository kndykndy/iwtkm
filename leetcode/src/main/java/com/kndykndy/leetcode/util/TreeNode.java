package com.kndykndy.leetcode.util;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode from(int self, Integer left, Integer right) {
        final TreeNode root = new TreeNode(self);
        root.left = left != null ? new TreeNode(left) : null;
        root.right = right != null ? new TreeNode(right) : null;
        return root;
    }

    public static void add(TreeNode node, int left, int right) {
        node.left = new TreeNode(left);
        node.right = new TreeNode(right);
    }

    public boolean isEqual(TreeNode tree) {
        return false;
    }
}
