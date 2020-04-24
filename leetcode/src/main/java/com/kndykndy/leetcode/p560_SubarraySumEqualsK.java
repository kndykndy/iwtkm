package com.kndykndy.leetcode;

import java.util.HashMap;

public class p560_SubarraySumEqualsK {

    interface Solution {

        int subarraySum(int[] nums, int k);
    }

    public static class BruteForceSolution implements Solution {

        @Override
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int result = 0, sum;

            for (int i = 0; i < nums.length; i++) {
                sum = 0;

                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum == k) {
                        result++;
                    }
                }
            }

            return result;
        }
    }

    public static class Solution1 implements Solution {

        @Override
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int result = 0;

            // consequent sum to its occurance
            final HashMap<Integer, Integer> sums = new HashMap<>();

            int sum = 0;

            for (int num : nums) {
                sum += num;
                if (sum == k) {
                    result++;
                }

                result += sums.getOrDefault(sum - k, 0);

//                sums.merge(sum, 1, (soFar, value) -> soFar + value);
                sums.merge(sum, 1, Integer::sum);
            }

            return result;
        }
    }
}
