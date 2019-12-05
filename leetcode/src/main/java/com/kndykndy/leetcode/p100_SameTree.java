package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.TreeNode;

public class p100_SameTree {

    interface Solution {

        boolean isSameTree(TreeNode p, TreeNode q);
    }

    public static class Solution1 implements Solution {

        @Override
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return isSameTreeImpl(p, q);
        }

        private boolean isSameTreeImpl(TreeNode p, TreeNode q) {
            if (p == q) {
                return true;
            } else if (p == null || q == null) {
                return false;
            } else {
                return p.val == q.val &&
                    isSameTreeImpl(p.left, q.left) &&
                    isSameTreeImpl(p.right, q.right);
            }
        }
    }
}
