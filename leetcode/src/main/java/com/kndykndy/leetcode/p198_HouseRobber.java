package com.kndykndy.leetcode;

public class p198_HouseRobber {

    interface Solution {

        int rob(int[] nums);
    }

    public static class Solution1 implements Solution {

        @Override
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int length = nums.length;
            final int[] dp = new int[length + 1];
            dp[0] = 0;
            dp[1] = nums[0];

            for (int i = 1; i < length; i++) {
                dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
            }

            return dp[length];
        }
    }
}
