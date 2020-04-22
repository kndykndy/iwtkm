package com.kndykndy.leetcode;

import java.util.HashSet;
import java.util.Set;

public class p10000_CountingElements {

    interface Solution {

        /**
         * Given an integer array arr, count element x such that x + 1 is also in arr.
         *
         * If there're duplicates in arr, count them separately.
         */
        int countElements(int[] arr);
    }

    public static class Solution1 implements Solution {

        @Override
        public int countElements(int[] arr) {
            int result = 0;

            final Set<Integer> set = new HashSet<>();

            for (int value : arr) {
                set.add(value);
            }

            for (int value : arr) {
                if (set.contains(value + 1)) {
                    result++;
                }
            }

            return result;
        }
    }
}
