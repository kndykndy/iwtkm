package com.kndykndy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode #18 ~ 4Sum
 * https://leetcode.com/problems/4sum
 *
 * 28 Mar 2018
 *
 * Problem statement:
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d =
 * target? Find all unique quadruplets in the array which gives the sum of target. Note: The
 * solution set must not contain duplicate quadruplets.
 *
 * Example:
 * Given array S = [1, 0, -1, 0, -2, 2], and target = 0, a solution set is:
 * [ [-1,  0, 0, 1], [-2, -1, 1, 2], [-2,  0, 0, 2] ]
 */
public class p018_FourSum {

    @SuppressWarnings("WeakerAccess")
    private static class Solution {

        public void wrapperForFourSum(int[] nums, int target) {
            System.out.print("Case for " + Arrays.toString(nums) + ", target " + target);
            Arrays.sort(nums);
            System.out.print(", sorted " + Arrays.toString(nums) + "\n");

            final long l = System.currentTimeMillis();

            final List<List<Integer>> result = fourSum(nums, target);
            System.out.print("Result: ");
            System.out.print("[");
            result.forEach(r ->
                System.out.print(
                    "[" + r.get(0) + "," + r.get(1) + "," + r.get(2) + "," + r.get(3) + "],"));
            System.out.print("]");

            System.out.print(", took " + (System.currentTimeMillis() - l) + "ms\n");
            System.out.println();
        }

        @SuppressWarnings("unused")
        private void debugPrint(int[] n, int i0, int i1, int i2, int i3) {
            System.out.println(
                i0 + " " + i1 + " " + i2 + " " + i3
                    + ": " + n[i0] + " " + n[i1] + " " + n[i2] + " " + n[i3]
                    + ", sum: " + (n[i0] + n[i1] + n[i2] + n[i3]));
        }

        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums == null || nums.length < 4) {
                return new ArrayList<>();
            }

            Arrays.sort(nums);

            final Set<List<Integer>> result = new HashSet<>();

            int i1, i2, i3;
            int s;

            for (int i0 = 0; i0 < nums.length - 3; i0++) {
                i1 = i0 + 1;

                while (i1 < nums.length - 2) {
                    i2 = i1 + 1;
                    i3 = nums.length - 1;

                    while (i2 < i3) {
//                        debugPrint(nums, i0, i1, i2, i3);

                        s = nums[i0] + nums[i1] + nums[i2] + nums[i3];
                        if (s != target) {
                            if (s < target) {
                                i2++;
                            } else {
                                i3--;
                            }
                        } else {
                            result.add(Arrays.asList(nums[i0], nums[i1], nums[i2], nums[i3]));

                            i2++;
                            i3--;
                        }
                    }

                    i1++;
                }
            }

            return new ArrayList<>(result);
        }

    }

    public static void main(String[] args) {
        new Solution().wrapperForFourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }

}
