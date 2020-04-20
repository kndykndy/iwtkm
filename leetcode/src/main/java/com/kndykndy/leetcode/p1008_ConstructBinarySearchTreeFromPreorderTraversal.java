package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class p1008_ConstructBinarySearchTreeFromPreorderTraversal {

    interface Solution {

        TreeNode bstFromPreorder(int[] preorder);
    }

    public static class BruteForceSolution implements Solution {

        @Override
        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }

            final TreeNode root = new TreeNode(preorder[0]);
            TreeNode tempNode, nNode;

            for (int i = 1; i < preorder.length; i++) {
                nNode = new TreeNode(preorder[i]);

                tempNode = root;
                while (true) {
                    if (preorder[i] < tempNode.val) {
                        if (tempNode.left == null) {
                            tempNode.left = nNode;
                            break;
                        } else {
                            tempNode = tempNode.left;
                        }
                    } else {
                        if (tempNode.right == null) {
                            tempNode.right = nNode;
                            break;
                        } else {
                            tempNode = tempNode.right;
                        }
                    }
                }
            }

            return root;
        }
    }

    public static class Solution1 implements Solution {

        @Override
        public TreeNode bstFromPreorder(int[] preorder) {
            Deque<TreeNode> q = new ArrayDeque<>();

            for (int val : preorder) {
                TreeNode node = new TreeNode(val);

                if (!q.isEmpty()) {
                    TreeNode prev = q.getFirst();

                    if (node.val < prev.val) {
                        prev.left = node;
                    } else {
                        // its more, but may be more than a parent
                        while (val > prev.val) {
                            prev = q.pollFirst();
                        }
                        if (val < prev.val) {
                            q.addFirst(prev);
                            prev = prev.left;
                        }

                        prev.right = node;
                    }

                    q.addFirst(node);
                } else {
                    q.addFirst(node);
                }
            }

            return q.getLast();
        }
    }
}
