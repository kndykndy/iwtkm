package com.kndykndy.epi.primitivetypes;

import java.util.Arrays;

public class BootCamp {

    public static final void method1() {
//        Arrays.copyOf();
//        System.arraycopy();
    }

    public static int binarySearch(int[] nums, int target) {
        final int l = nums.length;

        if (target < nums[0] || target > nums[l - 1]) {
            return -1;
        }

        int leftIdx = 0, rightIdx = l - 1, pivotIdx = l / 2;
        if (l % 2 == 0) {
            pivotIdx--;
        }

        while (true) {
            if (target == nums[pivotIdx]) {
                return pivotIdx;
            } else {
                if (target > nums[pivotIdx]) { // search right
                    leftIdx = pivotIdx + 1;
                    pivotIdx += (rightIdx - pivotIdx) / 2 + 1;
                } else { // search left
                    rightIdx = pivotIdx - 1;
                    pivotIdx -= (pivotIdx - leftIdx) / 2 + 1;
                }

                if (rightIdx == pivotIdx + 1 || leftIdx == pivotIdx - 1) {
                    if (target == nums[pivotIdx]) {
                        return pivotIdx;
                    } else if (pivotIdx + 1 < l && target == nums[pivotIdx + 1]) {
                        return pivotIdx + 1;
                    } else if (pivotIdx - 1 >= 0 && target == nums[pivotIdx - 1]) {
                        return pivotIdx - 1;
                    } else {
                        return -1;
                    }
                }
            }
        }
    }

    public static int binarySearch(int[] nums, int target, int leftIdx, int rightIdx) {
        final int l = rightIdx - leftIdx + 1;

        if (target < nums[leftIdx] || target > nums[rightIdx]) {
            return -1;
        }

        int pivotIdx = leftIdx + (rightIdx - leftIdx) / 2;
        if (l % 2 == 0) {
            pivotIdx--;
        }

        while (true) {
            if (target == nums[pivotIdx]) {
                return pivotIdx;
            } else {
                if (target > nums[pivotIdx]) { // search right
                    leftIdx = pivotIdx + 1;
                    pivotIdx += (rightIdx - pivotIdx) / 2 + 1;
                } else { // search left
                    rightIdx = pivotIdx - 1;
                    pivotIdx -= (pivotIdx - leftIdx) / 2 + 1;
                }

                if (rightIdx == pivotIdx + 1 || leftIdx == pivotIdx - 1) {
                    if (target == nums[pivotIdx]) {
                        return pivotIdx;
                    } else if (pivotIdx + 1 <= l && target == nums[pivotIdx + 1]) {
                        return pivotIdx + 1;
                    } else if (pivotIdx - 1 >= 0 && target == nums[pivotIdx - 1]) {
                        return pivotIdx - 1;
                    } else {
                        return -1;
                    }
                }
            }
        }
    }
}
