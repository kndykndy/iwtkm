package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.TreeNode;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /**
     * Time O(n), space O(k) (k is the depth of recursion).
     */
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

    /**
     * Time O(n), space O(m) (m is max nodes on same level).
     */
    public static class Solution3 implements Solution {

        @Override
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            final Queue<TreeNode> nodeQueue = new ArrayDeque<>();
            final List<TreeNode> nodes = new LinkedList<>();
            TreeNode tempNode;
            int maxDepth = 1;

            nodeQueue.add(root);

            while (true) {
                while (!nodeQueue.isEmpty()) {
                    tempNode = nodeQueue.poll();
                    if (tempNode.left != null) {
                        nodes.add(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        nodes.add(tempNode.right);
                    }
                }

                if (nodes.isEmpty()) {
                    break;
                }

                maxDepth++;

                nodeQueue.addAll(nodes);
                nodes.clear();
            }

            return maxDepth;
        }
    }

    public static class Solution4 implements Solution {

        @Override
        public int maxDepth(TreeNode root) {
            return root != null ?
                Math.max(maxDepthImpl(root.left, 2), maxDepthImpl(root.right, 2))
                : 0;
        }

        private int maxDepthImpl(TreeNode node, int level) {
            return node != null
                ? Math.max(maxDepthImpl(node.left, level + 1), maxDepthImpl(node.right, level + 1))
                : level - 1;
        }
    }
}
