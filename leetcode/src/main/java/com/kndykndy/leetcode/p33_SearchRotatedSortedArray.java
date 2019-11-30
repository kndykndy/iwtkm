package com.kndykndy.leetcode;

import java.util.Arrays;

public class p33_SearchRotatedSortedArray {

    interface Solution {

        int search(int[] nums, int target);
    }

    public static class Solution1 implements Solution {

        @Override
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            final int len = nums.length;

            if (len == 1) {
                return target == nums[0] ? 0 : -1;
            }
            if (len == 2) {
                if (target == nums[0]) {
                    return 0;
                } else if (target == nums[1]) {
                    return 1;
                } else {
                    return -1;
                }
            }
            if (nums[0] < nums[len - 1]) {
                int p = Arrays.binarySearch(nums, target);
                return p < 0 ? -1 : p;
            }

            int pivotIdx = len / 2;
            if (len % 2 == 0) {
                pivotIdx--;
            }

            if (target == nums[pivotIdx]) {
                return pivotIdx;
            }

            if (nums[0] < nums[pivotIdx]) { // left part is ordered, e.g. 1 2 4 5 6 7 0
                if (target >= nums[0] && target <= nums[pivotIdx]) {
                    int p = Arrays.binarySearch(nums, 0, pivotIdx + 2, target);
                    return p < 0 ? -1 : p;
                } else {
                    if (target < nums[0]) {
                        for (int i = len - 1; i > pivotIdx; i--) {
                            if (target == nums[i]) {
                                return i;
                            }
                        }
                    } else {
                        for (int i = pivotIdx + 1; i < len; i++) {
                            if (target == nums[i]) {
                                return i;
                            }
                        }
                    }
                    return -1;
                }
            } else { // right part is ordered, e.g. 6 7 0 1 2 4 5
                if (target >= nums[pivotIdx] && target <= nums[len - 1]) {
                    int p = Arrays.binarySearch(nums, pivotIdx, len, target);
                    return p < 0 ? -1 : p;
                } else {
                    if (target < nums[0]) {
                        for (int i = pivotIdx - 1; i > 0; i--) {
                            if (target == nums[i]) {
                                return i;
                            }
                        }
                    } else {
                        for (int i = 0; i < pivotIdx; i++) {
                            if (target == nums[i]) {
                                return i;
                            }
                        }
                    }
                    return -1;
                }
            }
        }
    }
}
