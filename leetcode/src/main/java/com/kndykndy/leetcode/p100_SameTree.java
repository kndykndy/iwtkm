package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.TreeNode;

public class p100_SameTree {

    interface Solution {

        boolean isSameTree(TreeNode p, TreeNode q);
    }

    public static class Solution1 implements Solution {

        @Override
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null ^ q == null) {
                return false;
            }

            return isSameTreeImpl(p, q);
        }

        private boolean isSameTreeImpl(TreeNode p, TreeNode q) {
            if (p == q) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && isSameTreeImpl(p.left, q.left) &&
                isSameTreeImpl(q.right, q.right);
        }
    }
}
