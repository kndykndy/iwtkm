package com.kndykndy.leetcode;

public class p268_MissingNumber {

    interface Solution {

        int missingNumber(int[] nums);
    }

    public static class Solution1 implements Solution {

        @Override
        public int missingNumber(int[] nums) {
            int max = -1, sum = 0;
            boolean hasZero = false;
            for (int num : nums) {
                if (num == 0) {
                    hasZero = true;
                }
                max = Math.max(max, num);
                sum += num;
            }

            final int pSum = (max * (1 + max)) / 2; // (n(a1+an))/2 ~ sum of arithmetic progression
            final int missing = pSum - sum;

            return hasZero ? (missing != 0 ? missing : max + 1) : 0;
        }
    }
}
