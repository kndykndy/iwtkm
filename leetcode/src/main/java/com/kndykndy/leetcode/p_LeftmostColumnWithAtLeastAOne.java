package com.kndykndy.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p_LeftmostColumnWithAtLeastAOne {

    interface Solution {

        int leftMostColumnWithOne(BinaryMatrix binaryMatrix);
    }

    interface BinaryMatrix {

        /**
         * @return the element of the matrix at index (x, y) (0-indexed)
         */
        int get(int x, int y);

        /**
         * @return a list of 2 elements [n, m], which means the matrix is n * m
         */
        List<Integer> dimensions();
    }

    public static class BruteForceSolution implements Solution {

        @Override
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            final List<Integer> dimensions = binaryMatrix.dimensions();
            final int rows = dimensions.get(0), cols = dimensions.get(1);

            final Set<Integer> baseCase = new HashSet<>();

            for (int row = 0; row < rows; row++) {
                if (binaryMatrix.get(row, cols - 1) == 1) {
                    baseCase.add(row);
                }
            }
            if (baseCase.isEmpty()) {
                return -1;
            }

            int lastCol = cols - 1, curCol = lastCol - 1;
            final Set<Integer> tempCase = new HashSet<>();

            while (curCol >= 0) {

                tempCase.clear();
                for (Integer row : baseCase) {
                    if (binaryMatrix.get(row, curCol) == 1) {
                        tempCase.add(row);
                    }
                }

                if (!tempCase.isEmpty()) {
                    baseCase.retainAll(tempCase);
                    lastCol = curCol;
                    curCol--;
                } else {
                    break;
                }
            }

            return lastCol;
        }
    }

    public static class Solution1 implements Solution {

        @Override
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            final List<Integer> dimensions = binaryMatrix.dimensions();
            final int rows = dimensions.get(0), cols = dimensions.get(1);

            final Set<Integer> baseCase = new HashSet<>();

            for (int row = 0; row < rows; row++) {
                if (binaryMatrix.get(row, cols - 1) == 1) {
                    baseCase.add(row);
                }
            }
            if (baseCase.isEmpty()) {
                return -1;
            }

            // do one-way backward binary split

            int prevCol = cols - 1, curCol = prevCol / 2;

            final Set<Integer> tempCase = new HashSet<>();

            while (curCol >= 0) {

                tempCase.clear();
                for (Integer row : baseCase) {
                    if (binaryMatrix.get(row, curCol) == 1) {
                        tempCase.add(row);
                    }
                }

                if (!tempCase.isEmpty()) {
                    baseCase.retainAll(tempCase);
                    prevCol = curCol;

                    curCol -= curCol / 2;
                    if (curCol == prevCol) {
                        if (curCol == 0) {
                            return prevCol;
                        } else {
                            curCol = 0;
                        }
                    }
                } else {
                    break;
                }
            }

            for (int col = curCol + 1; col < prevCol; col++) {

                tempCase.clear();
                for (Integer row : baseCase) {
                    if (binaryMatrix.get(row, col) == 1) {
                        tempCase.add(row);
                    }
                }

                if (!tempCase.isEmpty()) {
                    return col;
                }
            }

            return prevCol;
        }
    }

    public static class Solution2 implements Solution {

        @Override
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            final List<Integer> dimensions = binaryMatrix.dimensions();
            final int rows = dimensions.get(0), cols = dimensions.get(1);

            int row = 0, col = cols - 1;

            while (row < rows && col >= 0) {
                if (binaryMatrix.get(row, col) == 1) { // move left
                    col--;
                } else { // move down
                    row++;
                }
            }

            return col < cols - 1 ? col + 1 : -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new Solution1().leftMostColumnWithOne(
                new BinaryMatrix() {
                    private final int[][] m1 = {
                        {0, 0, 0, 1},
                        {0, 0, 1, 1},
                        {0, 1, 1, 1},
                    };

                    private int[][] getDataProvider() {
                        return m1;
                    }

                    @Override
                    public int get(int x, int y) {
                        return getDataProvider()[x][y];
                    }

                    @Override
                    public List<Integer> dimensions() {
                        return Arrays.asList(getDataProvider().length, getDataProvider()[0].length);
                    }
                }));
    }
}
