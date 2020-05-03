package com.kndykndy.leetcode;

public class p014_LongestCommonPrefix {

    interface Solution {

        String longestCommonPrefix(String[] strs);
    }

    public static class Solution1 implements Solution {

        @Override
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            int minLen = Integer.MAX_VALUE;
            for (String str : strs) {
                if (str.length() < minLen) {
                    minLen = str.length();
                }
            }

            for (int i = 0; i < minLen; i++) {
                char c = strs[0].charAt(i);

                for (String str : strs) {
                    if (str.charAt(i) != c) {
                        return str.substring(0, i);
                    }
                }
            }

            return strs[0].substring(0, minLen);
        }
    }
}
