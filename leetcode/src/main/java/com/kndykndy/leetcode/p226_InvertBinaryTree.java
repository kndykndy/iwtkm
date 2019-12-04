package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.TreeNode;

public class p226_InvertBinaryTree {

    interface Solution {

        TreeNode invertTree(TreeNode root);
    }

    public static class Solution1 implements Solution {

        @Override
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            invertImpl(root);

            return root;
        }

        private void invertImpl(TreeNode root) {
            if (root == null) {
                return;
            }

            final TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertImpl(root.left);
            invertImpl(root.right);
        }
    }
}
