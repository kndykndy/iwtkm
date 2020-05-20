package com.kndykndy.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class p_FindLastNonRepeatingChar {

    interface Solution {

        char getLastNonRepeated(String inputStr);
    }

    public static class Solution1 implements Solution {

        @Override
        public char getLastNonRepeated(String inputStr) {
            if (inputStr == null || inputStr.length() == 0) {
                return 0;
            }

            char result = 0;

            final Map<Character, Integer> charsFrequencies = new LinkedHashMap<>();

            for (int i = 0; i < inputStr.length(); i++) {
                charsFrequencies.merge(inputStr.charAt(i), 1, Integer::sum);
            }

            for (Entry<Character, Integer> entry : charsFrequencies.entrySet()) {
                if (entry.getValue() == 1) {
                    result = entry.getKey();
                }
            }

            return result;
        }
    }
}
