package com.kndykndy.leetcode;

public class p026_RemoveDuplicatesFromSortedArray {

    interface Solution {

        int removeDuplicates(int[] nums);
    }

    public static class Solution1 implements Solution {

        @Override
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int idx = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[idx]) {
                    nums[++idx] = nums[i];
                }
            }

            return idx + 1;
        }
    }
}
