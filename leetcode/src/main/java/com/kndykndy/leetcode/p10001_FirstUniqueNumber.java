package com.kndykndy.leetcode;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class p10001_FirstUniqueNumber {

    interface Solution {

        int showFirstUnique();

        void add(int value);
    }

    static class Solution1 implements Solution {

        private final Set<Integer> repeated = new HashSet<>();
        private final Set<Integer> unique = new LinkedHashSet<>();

        public Solution1(int[] nums) {
            for (int num : nums) {
                add(num);
            }
        }

        @Override
        public int showFirstUnique() {
            return unique.stream().findFirst().orElse(-1);
        }

        @Override
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

    static class Solution2 implements Solution {

        private final Map<Integer, Integer> m = new LinkedHashMap<>();

        public Solution2(int[] nums) {
            for (int num : nums) {
                add(num);
            }
        }

        @Override
        public int showFirstUnique() {
            return m.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(Entry::getKey)
                .orElse(-1);
        }

        @Override
        public void add(int value) {
            m.merge(value, 1, Integer::sum);
        }
    }
}
