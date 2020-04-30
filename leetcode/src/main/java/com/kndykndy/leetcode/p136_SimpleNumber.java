package com.kndykndy.leetcode;

import java.util.HashSet;
import java.util.Set;

public class p136_SimpleNumber {

    interface Solution {

        int singleNumber(int[] nums);
    }

    public static class Solution1 implements Solution {

        @Override
        public int singleNumber(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            final Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            }

            return set.iterator().next();
        }
    }

    public static class OptimalSolution implements Solution {

        @Override
        public int singleNumber(int[] nums) {
            int a = 0;
            for (int i : nums) {
                a ^= i;
            }
            return a;
        }
    }
}
