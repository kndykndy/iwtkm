package com.kndykndy.leetcode;

public class p153_FindMinimumRotatedSortedArray {

    interface Solution {

        int findMin(int[] nums);
    }

    public static class Solution1 implements Solution {

        @Override
        public int findMin(int[] nums) {
            int l = nums.length;
            if (nums[0] > nums[l - 1]) {
                int j = l - 1;
                while (j > 0) {
                    if (nums[j - 1] > nums[j]) {
                        break;
                    }
                    j--;
                }
                return nums[j];
            } else {
                return nums[0];
            }
        }
    }
}
