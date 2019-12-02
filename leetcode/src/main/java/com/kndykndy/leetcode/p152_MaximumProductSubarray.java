package com.kndykndy.leetcode;

public class p152_MaximumProductSubarray {

    interface Solution {

        int maxProduct(int[] nums);
    }

    public static class Solution1 implements Solution {

        @Override
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int currentMin = 1, currentMax = 1, globalMax = Integer.MIN_VALUE;

            for (int num : nums) {
                int prevCurrentMax = currentMax;
                currentMax = Math.max(Math.max(currentMax * num, currentMin * num), num);
                currentMin = Math.min(Math.min(prevCurrentMax * num, currentMin * num), num);
                if (currentMax > globalMax) {
                    globalMax = currentMax;
                }
            }

            return globalMax;
        }
    }
}
