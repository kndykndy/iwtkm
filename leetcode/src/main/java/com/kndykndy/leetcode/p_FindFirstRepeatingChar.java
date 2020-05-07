package com.kndykndy.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class p_FindFirstRepeatingChar {

    interface Solution {

        Character findFirstRepeatingChar(String str);
    }

    public static class Solution1 implements Solution {

        @Override
        public Character findFirstRepeatingChar(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }

            final Map<Character, Integer> frequenciesMap = new LinkedHashMap<>();
            final int v = str.chars()
                .filter(c -> frequenciesMap.merge((char) c, 1, Integer::sum) > 1)
                .findFirst()
                .orElse(-1);
            return v != -1 ? (char) v : null;
        }
    }
}
