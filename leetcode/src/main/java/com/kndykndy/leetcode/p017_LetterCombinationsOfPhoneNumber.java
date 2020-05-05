package com.kndykndy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p017_LetterCombinationsOfPhoneNumber {

    interface Solution {

        /**
         * Phone keyboard:
         * 1     2abc 3def
         * 4ghi  5jkl 6mno
         * 7pqrs 8tuv 9wxyz
         * *     0    #
         */
        List<String> letterCombinations(String digits);
    }

    public static class Solution1 implements Solution {

        final Map<Character, String> map =
            new HashMap<>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};

        @Override
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return Collections.emptyList();
            }

            final List<String> result = new ArrayList<>();

            final int digitLen = digits.length();
            final String[] p = new String[digitLen];
            for (int i = 0; i < digitLen; i++) {
                p[i] = map.get(digits.charAt(i));
            }

            final int[] indexes = new int[digitLen];

            do {
                char[] temp = new char[digitLen];
                for (int i = 0; i < indexes.length; i++) {
                    temp[i] = p[i].charAt(indexes[i]);
                }
                result.add(new String(temp));
            } while (hasNextIteration(p, indexes));

            return result;
        }

        private boolean hasNextIteration(String[] p, int[] indexes) {
            for (int i = indexes.length - 1; i >= 0; i--) {
                if (indexes[i] < p[i].length() - 1) {
                    indexes[i]++;
                    return true;
                } else {
                    indexes[i] = 0;
                }
            }
            return false;
        }
    }

    public static class Solution2 implements Solution {

        final Map<Character, String> map =
            new HashMap<>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};

        @Override
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return Collections.emptyList();
            }

            final List<String> result = new ArrayList<>();

            final int digitLen = digits.length();
            final String[] p = new String[digitLen];
            for (int i = 0; i < digitLen; i++) {
                p[i] = map.get(digits.charAt(i));
            }

            final int[] indexes = new int[digitLen];

            final char[] temp = new char[digitLen];
            for (int i = 0; i < indexes.length; i++) {
                temp[i] = p[i].charAt(indexes[i]);
            }

            do {
                result.add(new String(temp));
            } while (hasNextIteration(p, indexes, temp));

            return result;
        }

        private boolean hasNextIteration(String[] p, int[] indexes, char[] temp) {
            for (int i = indexes.length - 1; i >= 0; i--) {
                if (indexes[i] < p[i].length() - 1) {
                    indexes[i]++;
                    temp[i] = p[i].charAt(indexes[i]);
                    return true;
                } else {
                    indexes[i] = 0;
                    temp[i] = p[i].charAt(0);
                }
            }
            return false;
        }
    }
}
