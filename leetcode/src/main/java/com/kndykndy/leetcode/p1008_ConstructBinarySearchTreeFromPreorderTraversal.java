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
            final Deque<TreeNode> stack = new ArrayDeque<>();

            final TreeNode root = new TreeNode(preorder[0]);

            TreeNode node, latest;

            for (int i = 1; i < preorder.length; i++) {
                node = new TreeNode(preorder[i]);

                if (preorder[i - 1] < root.val && node.val > root.val) {
                    stack.clear();
                }

                latest = stack.peekFirst();
                while (!stack.isEmpty() && stack.peekFirst().val < node.val) {
                    latest = stack.pollFirst();
                }
                if (latest == null) {
                    latest = root;
                }

                if (node.val < latest.val) {
                    latest.left = node;
                } else {
                    latest.right = node;
                }

                stack.addFirst(node);
            }

            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution1().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        int a = 0;
    }
}
