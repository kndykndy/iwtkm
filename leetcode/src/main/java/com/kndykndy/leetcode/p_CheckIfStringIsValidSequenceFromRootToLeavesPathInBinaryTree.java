package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class p_CheckIfStringIsValidSequenceFromRootToLeavesPathInBinaryTree {

    interface Solution {

        /**
         * 1 <= arr.length <= 5000
         * 0 <= arr[i] <= 9
         * Each node's value is between [0 - 9].
         */
        boolean isValidSequence(TreeNode root, int[] arr);
    }

    public static class Solution1 implements Solution {

        @Override
        public boolean isValidSequence(TreeNode root, int[] arr) {
            if (root == null) {
                return false;
            }

            return isValidSequenceHelper(root, arr, 0);
        }

        private boolean isValidSequenceHelper(TreeNode root, int[] arr, int from) {
            final List<TreeNode> nodes = new ArrayList<>(2);
            nodes.add(root);

            for (int i = from; i < arr.length; i++) {
                final int fI = i;
                final List<TreeNode> tempNodes =
                    nodes.stream().filter(it -> it.val == arr[fI])
                    .collect(Collectors.toList());

                if (tempNodes.isEmpty()) {
                    return false;
                } else if (tempNodes.size() == 2) {
                    return isValidSequenceHelper(tempNodes.get(0), arr, i)
                        || isValidSequenceHelper(tempNodes.get(1), arr, i);
                } else {
                    nodes.clear();
                    final TreeNode tempNode = tempNodes.get(0);
                    if (tempNode.left != null) {
                        nodes.add(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        nodes.add(tempNode.right);
                    }
                }
            }

            return nodes.isEmpty();
        }
    }
}
