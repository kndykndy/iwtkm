package com.kndykndy.leetcode;

public class p283_MoveZeroes {

    interface Solution {

        /**
         * You must do this in-place without making a copy of the array.
         * Minimize the total number of operations.
         */
        void moveZeroes(int[] nums);
    }

    public static class Solution1 implements Solution {

        @Override
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            int len = nums.length;
            int currentPos = 0, ptr = 0;
            int zeroesCnt = 0;

            while (currentPos + zeroesCnt < len) {

                while (ptr < len && nums[ptr] == 0) {
                    zeroesCnt++;
                    ptr++;
                }

                while (ptr < len && nums[ptr] != 0) {
                    nums[currentPos++] = nums[ptr++];
                }
            }

            // cutoff -- nullify what's rest
            for (int i = len - 1; i >= len - zeroesCnt; i--) {
                nums[i] = 0;
            }
        }
    }

    public static class Solution2 implements Solution {

        @Override
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            int len = nums.length;
            int currentPos = 0;
            int zeroesCnt = 0;

            for (int i = 0; i < len; i++) {
                if (nums[i] != 0) {
                    nums[currentPos++] = nums[i];
                } else {
                    zeroesCnt++;
                }
            }

            // cutoff -- nullify what's rest
            for (int i = len - 1; i >= len - zeroesCnt; i--) {
                nums[i] = 0;
            }
        }
    }
}
