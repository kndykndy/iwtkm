package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.TreeNode;

public class p104_MaximumDepthBinaryTree {

    interface Solution {

        int maxDepth(TreeNode root);
    }

    /**
     * Time O(n), space O(k) (k is the depth of recursion).
     */
    public static class Solution1 implements Solution {

        @Override
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            final int[] max = new int[]{1};

            traverse(root, max, 1);

            return max[0];
        }

        private void traverse(TreeNode root, int[] max, int level) {
            if (level > max[0]) {
                max[0] = level;
            }

            if (root.left != null) {
                traverse(root.left, max, level + 1);
            }
            if (root.right != null) {
                traverse(root.right, max, level + 1);
            }
        }
    }

    public static class Solution2 implements Solution {

        @Override
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return traverse(root, 1);
        }

        private int traverse(TreeNode root, int level) {
            int maxLeft = level, maxRight = level;
            if (root.left != null) {
                maxLeft = traverse(root.left, level + 1);
            }
            if (root.right != null) {
                maxRight = traverse(root.right, level + 1);
            }

            return Math.max(maxLeft, maxRight);
        }
    }
}
