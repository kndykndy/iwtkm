package com.kndykndy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class p064_MinimumPathSum {

    interface Solution {

        int minPathSum(int[][] grid);
    }

    public static class Solution1 implements Solution {

        public int minPathSum(int[][] grid) {
            return visit(grid, 0, 0, new HashMap<>());
        }

        private int visit(int[][] grid, int fromRow, int fromCol, Map<String, Integer> memo) {
            final String key = fromRow + "-" + fromCol;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            int self = grid[fromRow][fromCol], v;

            if (fromRow < grid.length - 1 && fromCol < grid[0].length - 1) {
                v = self +
                    Math.min(
                        visit(grid, fromRow + 1, fromCol, memo),
                        visit(grid, fromRow, fromCol + 1, memo));
            } else {
                if (fromRow < grid.length - 1) {
                    v = self + visit(grid, fromRow + 1, fromCol, memo);
                } else if (fromCol < grid[0].length - 1) {
                    v = self + visit(grid, fromRow, fromCol + 1, memo);
                } else {
                    v = self;
                }
            }

            memo.put(key, v);

            return v;
        }
    }
}
