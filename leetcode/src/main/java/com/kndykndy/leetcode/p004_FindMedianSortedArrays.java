package com.kndykndy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode #4 ~ Median of Two Sorted Arrays
 *
 * 12 Mar 2018
 *
 * Problem statement:
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the
 * two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3], nums2 = [2], the median is 2.0
 * Example 2:
 * nums1 = [1, 2], nums2 = [3, 4], the median is (2 + 3)/2 = 2.5
 */
public class p004_FindMedianSortedArrays {

    interface Solution {

        double findMedianSortedArrays(int[] nums1, int[] nums2);
    }

    public static class BruteForceSolution implements Solution {

        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            final List<Integer> mergedArray = new ArrayList<>();
            Arrays.stream(nums1).forEach(mergedArray::add);
            Arrays.stream(nums2).forEach(mergedArray::add);

            Collections.sort(mergedArray);
            final int mergedArraySize = mergedArray.size();
            if (mergedArraySize % 2 == 0) {
                return (mergedArray.get(mergedArraySize / 2 - 1)
                    + mergedArray.get(mergedArraySize / 2)) / 2.0;
            } else {
                return mergedArray.get(mergedArraySize / 2);
            }
        }
    }
}
