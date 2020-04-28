package com.kndykndy.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class p10001_FirstUniqueNumber {

    static class FirstUnique {

        private final Set<Integer> repeated = new HashSet<>();
        private final Set<Integer> unique = new LinkedHashSet<>();

        public FirstUnique(int[] nums) {
            for (int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            return unique.stream().findFirst().orElse(-1);
        }

        public void add(int value) {
            if (unique.contains(value)) {
                unique.remove(value);
                repeated.add(value);
            } else {
                if (!repeated.contains(value)) {
                    unique.add(value);
                }
            }
        }
    }
}
