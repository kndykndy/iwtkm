package com.kndykndy.leetcode;

public class p221_MaximalSquare {

    interface Solution {

        int maximalSquare(char[][] matrix);
    }

    public static class Solution1 implements Solution {

        @Override
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }

            final int rows = matrix.length, cols = matrix[0].length;
            int max = 0;

            final int[][] dp = new int[rows + 1][cols + 1];

            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] =
                            Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        max = Math.max(dp[i][j], max);
                    }
                }
            }

            return max * max;
        }
    }
}
