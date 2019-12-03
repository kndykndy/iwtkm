package com.kndykndy.leetcode.util;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode from(int left, int self, int right) {
        final TreeNode root = new TreeNode(self);
        root.left = new TreeNode(left);
        root.right = new TreeNode(right);
        return root;
    }

    public static void add(TreeNode node, int left, int right) {
        node.left = new TreeNode(left);
        node.right = new TreeNode(right);
    }
}
