package com.kndykndy.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class p387_FirstUniqueCharInString {

    interface Solution {

        /**
         * Given a string, find the first non-repeating character in it and return it's index. If it
         * doesn't exist, return -1.
         */
        int firstUniqChar(String s);
    }

    public static class Solution1 implements Solution {

        @Override
        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0) {
                return -1;
            }

            final Map<Character, Integer> frequenciesMap = new LinkedHashMap<>();

            s.chars().forEach(c -> frequenciesMap.merge((char) c, 1, Integer::sum));

            final Optional<Character> firstNonRepeatingChar =
                frequenciesMap.entrySet().stream()
                    .filter(p -> p.getValue() == 1)
                    .map(Entry::getKey)
                    .findFirst();

            if (firstNonRepeatingChar.isPresent()) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == firstNonRepeatingChar.get()) {
                        return i;
                    }
                }
            }

            return -1;
        }
    }
}
