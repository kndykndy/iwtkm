package com.kndykndy.leetcode;

public class p200_NumberOfIslands {

    interface Solution {

        int numIslands(char[][] grid);
    }

    public static class Solution1 implements Solution {

        @Override
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }

            int result = 0;

            final int rows = grid.length, cols = grid[0].length;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (grid[row][col] == '1') {
                        result++;
                        waterizeLand(grid, row, col);
                    }
                }
            }

            return result;
        }

        private void waterizeLand(char[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[0].length
                || grid[row][col] == '0') {
                return;
            }

            grid[row][col] = '0'; // make it water ~ waterize

            waterizeLand(grid, row, col + 1); // waterize right
            waterizeLand(grid, row + 1, col); // waterize down
            waterizeLand(grid, row, col - 1); // waterize left
            waterizeLand(grid, row - 1, col); // waterize top
        }
    }
}
