package com.kndykndy.leetcode;

public class p053_MaximumSubarray {

    interface Solution {

        int maxSubArray(int[] nums);
    }

    /**
     * Time O(n), space O(1).
     * Kadane's algorithm.
     */
    public static class Solution1 implements Solution {

        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }

            int localMax = 0, globalMax = Integer.MIN_VALUE;

            for (int num : nums) {
                localMax = Math.max(localMax + num, num);
                if (localMax > globalMax) {
                    globalMax = localMax;
                }
            }

            return globalMax;
        }
    }

    /**
     * Divide and conquer. Time O(nlogn), space O(mn) (where m is space per recursion step and n is
     * recursion steps amount)
     */
    public static class Solution2 implements Solution {

        @Override
        public int maxSubArray(int[] nums) {
            return maxSubArray(nums, 0, nums.length - 1);
        }

        private int maxSubArray(int[] nums, int leftIdx, int rightIdx) {
            if (rightIdx - leftIdx == 0) {
                return nums[leftIdx];
            }

            int middleIdx = leftIdx + (rightIdx - leftIdx) / 2;

            return Math.max(
                Math.max(
                    maxSubArray(nums, leftIdx, middleIdx),
                    maxSubArray(nums, middleIdx + 1, rightIdx)
                ), maxSubArray(nums, leftIdx, middleIdx, rightIdx)
            );
        }

        private int maxSubArray(int[] nums, int leftIdx, int middleIdx, int rightIdx) {
            int sumLeft = Integer.MIN_VALUE;
            int sum = 0;

            for (int i = middleIdx; i >= leftIdx; i--) {
                sum += nums[i];
                if (sum > sumLeft) {
                    sumLeft = sum;
                }
            }

            int sumRight = Integer.MIN_VALUE;
            sum = 0;

            for (int i = middleIdx + 1; i <= rightIdx; i++) {
                sum += nums[i];
                if (sum > sumRight) {
                    sumRight = sum;
                }
            }

            return sumLeft + sumRight;
        }
    }
}
