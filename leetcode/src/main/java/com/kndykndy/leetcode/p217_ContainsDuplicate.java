package com.kndykndy.leetcode;

import java.util.HashSet;
import java.util.Set;

public class p217_ContainsDuplicate {

    /**
     * Time O(n), space O(n).
     */
    public static boolean containsDuplicate(int[] nums) {
        final Set<Integer> integers = new HashSet<>();

        for (int num : nums) {
            if (integers.contains(num)) {
                return true;
            } else {
                integers.add(num);
            }
        }

        return false;
    }
}
