package com.kndykndy;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode #1 ~ Two Sum https://leetcode.com/problems/two-sum/
 *
 * 16 Mar 2018
 *
 * Problem statement: Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have exactly one solution, and
 * you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9.
 * As nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * Solutions:
 * 1. Naive combinations
 * 2. Kind of selection sort -- pick up item, then choose a complement for it
 * 3. Pick up item, look if has complement in a specific hash table, if not, add.
 */
public class _p1_TwoSum {

    interface Solution {

        int[] twoSum(int[] nums, int target);
    }

    public static class Solution1 implements Solution {

        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 1) {
                return null;
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[]{i, j};
                    }
                }
            }

            return null;
        }
    }

    public static class Solution2 implements Solution {

        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 1) {
                return null;
            }

            // key is an int, value is its index within a nums array
            final Map<Integer, Integer> caughtInts = new HashMap<>();

            Integer tempInt;
            for (int i = 0; i < nums.length; i++) {
                tempInt = caughtInts.get(target - nums[i]);
                if (tempInt != null) {
                    return new int[]{tempInt, i};
                } else {
                    caughtInts.put(nums[i], i);
                }
            }

            return null;
        }
    }
}
