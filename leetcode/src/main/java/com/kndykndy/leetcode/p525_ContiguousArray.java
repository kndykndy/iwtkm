package com.kndykndy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class p525_ContiguousArray {

    interface Solution {

        int findMaxLength(int[] nums);
    }

    public static class BruteForceSolution implements Solution {

        @Override
        public int findMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int len = nums.length;

            int result = 0, sum;

            for (int i = 0; i < len; i++) {
                sum = 0;
                for (int j = i; j < len; j++) {
                    sum += nums[j] == 1 ? 1 : -1;
                    if (sum == 0 && (j - i + 1) > result) {
                        result = (j - i + 1);
                    }
                }
            }

            return result;
        }
    }

    public static class Solution2 implements Solution {

        @Override
        public int findMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int result = 0, sum = 0;

            final Map<Integer, Integer> m = new HashMap<>();
            m.put(0, -1);

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i] == 1 ? 1 : -1;
                if (m.containsKey(sum)) {
                    result = Math.max(result, i - m.get(sum));
                } else {
                    m.put(sum, i);
                }
            }

            return result;
        }
    }
}
