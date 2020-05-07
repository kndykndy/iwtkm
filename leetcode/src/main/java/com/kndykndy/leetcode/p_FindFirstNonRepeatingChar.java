package com.kndykndy.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class p_FindFirstNonRepeatingChar {

    interface Solution {

        Character findFirstNonRepeatingChar(String str);
    }

    public static class Solution1 implements Solution {

        @Override
        public Character findFirstNonRepeatingChar(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }

            final Map<Character, Integer> frequenciesMap = new LinkedHashMap<>();

            str.chars().forEach(c -> frequenciesMap.merge((char) c, 1, Integer::sum));

            final Optional<Character> firstNonRepeatingChar =
                frequenciesMap.entrySet().stream()
                    .filter(p -> p.getValue() == 1)
                    .map(Entry::getKey)
                    .findFirst();

            return firstNonRepeatingChar.orElse(null);
        }
    }
}
