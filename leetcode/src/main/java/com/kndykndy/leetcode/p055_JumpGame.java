package com.kndykndy.leetcode;

import java.util.Arrays;

public class p055_JumpGame {

    interface Solution {

        boolean canJump(int[] nums);
    }

    public static class BruteForceSolution implements Solution {

        @Override
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            if (nums.length == 1) {
                return true;
            }

            for (int currentPos = nums[0]; currentPos > 0; currentPos--) {
                if (jumpImpl(nums, currentPos)) {
                    return true;
                }
            }

            return false;
        }

        private boolean jumpImpl(int[] nums, int currentPos) {
            if (currentPos > nums.length - 1) { // outside
                return false;
            } else if (currentPos == nums.length - 1) {
                return true;
            }

            for (int i = nums[currentPos]; i > 0; i--) {
                if (jumpImpl(nums, currentPos + i)) {
                    return true;
                }
            }

            return false;
        }
    }

//    public static class Solution1 implements Solution {
//
//        @Override
//        public boolean canJump(int[] nums) {
//
//        }
//    }

    public static class DpMemoizationSolution implements Solution {

        @Override
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            if (nums.length == 1) {
                return true;
            }

            final int[] waysToGet = new int[nums.length];
            Arrays.fill(waysToGet, Integer.MAX_VALUE);
            waysToGet[0] = 0;

            for (int i = nums[0]; i > 0; i--) {
                jumpImpl(nums, i, waysToGet, 1);
            }

            final int result = waysToGet[waysToGet.length - 1];
            return result != Integer.MAX_VALUE;
        }

        private void jumpImpl(int[] nums, int pos, int[] waysToGet, int jumpIdx) {
            if (pos > nums.length - 1) {
                return;
            }

            if (jumpIdx < waysToGet[pos]) {
                waysToGet[pos] = jumpIdx;
                for (int i = nums[pos]; i > 0; i--) {
                    jumpImpl(nums, pos + i, waysToGet, jumpIdx + 1);
                }
            }
        }
    }
}
