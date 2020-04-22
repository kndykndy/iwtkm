package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.TreeNode;

public class p543_DiameterOfBinaryTree {

    interface Solution {

        int diameterOfBinaryTree(TreeNode root);
    }

    public static class Solution1 implements Solution {

        @Override
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return Math.max(
                height(root.left) + height(root.right),
                Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
        }

        private int height(TreeNode node) {
            return node != null ? 1 + Math.max(height(node.left), height(node.right)) : 0;
        }
    }
}
