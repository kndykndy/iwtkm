package com.kndykndy.leetcode;

public class p287_FindDuplicateNumber {

    interface Solution {

        int findDuplicate(int[] nums);
    }

    public static class Solution1 implements Solution {

        @Override
        public int findDuplicate(int[] nums) {
            // find the cycle

            int tortoise = nums[0];
            int hare = nums[0];
            do {
                tortoise = nums[tortoise];
                hare = nums[nums[hare]];
            } while (tortoise != hare);

            // find entrance of the cycle

            tortoise = nums[0];
            while (tortoise != hare) {
                tortoise = nums[tortoise];
                hare = nums[hare]; //  slow down hare this cycle
            }

            return tortoise;
        }
    }

    public static void main(String[] args) {
        new Solution1().findDuplicate(new int[]{1, 3, 4, 2, 2});
    }
}
