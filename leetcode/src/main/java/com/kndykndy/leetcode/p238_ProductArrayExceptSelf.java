package com.kndykndy.leetcode;

public class p238_ProductArrayExceptSelf {

    interface Solution {

        int[] productExceptSelf(int[] nums);
    }

    /**
     * Time O(n), space O(1) (if not taking result array into account as per statement.)
     */
    public static class Solution1 implements Solution {

        @Override
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] result = new int[length];
            int product = 1;
            result[0] = 1;
            for (int i = 1; i < length; i++) {
                product *= nums[i - 1];
                result[i] = product;
            }
            product = 1;
            for (int i = length - 1 - 1; i >= 0; i--) {
                product *= nums[i + 1];
                result[i] *= product;
            }
            return result;
        }
    }
}
