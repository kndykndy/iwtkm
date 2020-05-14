package com.kndykndy.leetcode;

public class p027_RemoveElement {

    interface Solution {

        int removeElement(int[] nums, int val);
    }

    public static class Solution1 implements Solution {

        @Override
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int idx = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[idx++] = nums[i];
                }
            }

            return idx;
        }
    }
}
