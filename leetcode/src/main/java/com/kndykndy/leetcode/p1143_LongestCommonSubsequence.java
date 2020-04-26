package com.kndykndy.leetcode;

public class p1143_LongestCommonSubsequence {

    interface Solution {

        /**
         * 1 <= text1.length <= 1000
         * 1 <= text2.length <= 1000
         * The input strings consist of lowercase English characters only.
         */
        int longestCommonSubsequence(String text1, String text2);
    }

    public static class Solution1 implements Solution {

        @Override
        public int longestCommonSubsequence(String text1, String text2) {
            final int length1 = text1.length(), length2 = text2.length();

            final int[][] dp = new int[length2 + 1][length1 + 1];

            for (int i = 1; i <= length2; i++) {
                for (int j = 1; j <= length1; j++) {
                    dp[i][j] = text2.charAt(i - 1) == text1.charAt(j - 1)
                        ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            return dp[length2][length1];
        }
    }
}
