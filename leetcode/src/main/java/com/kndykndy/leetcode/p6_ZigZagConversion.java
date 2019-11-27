package com.kndykndy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode #6 ~ ZigZag Conversion
 * https://leetcode.com/problems/zigzag-conversion
 *
 * 17 Mar 2018
 *
 * Problem statement:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * P   A   H   N
 * _A P L S I I G
 * __Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Example:
 * Write the code that will take a string and make this conversion given a number of rows:
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class p6_ZigZagConversion {

    interface Solution {

        String convert(String s, int numRows);

    }

    @SuppressWarnings("WeakerAccess")
    private static class Solution1 implements Solution {

        /**
         * Open questions and assumptions:
         * May input string be null? No, return null. Empty? Yes, return empty string.
         * May numRows be less than one? No, return null. One? Yes, return input string.
         * May numRows be even? Yes, any.
         *
         * KNDYLOLOMYRABMBL (16 chars) with 4 rows
         * 0: K     L     B     3 chars, 5 chars below, 0 chars above
         * 1:  N   O O   A M    5 chars, 3 chars below, 1 char above
         * 2:   D L   M R   B   5 chars, 1 char below, 3 chars above
         * 3:    Y     Y     L  3 chars, 0 chars below, 5 chars above
         * And KLBNOOAMDLMRBYYL as result.
         *
         * ABCDEF (6 chars) with 4 rows
         * 0: A                 1 char, 5 chars below, 0 chars above
         * 1:  B   F            2 chars, 3 chars below, 1 chars above
         * 2:   C E             2 chars, 1 chars below, 3 chars above
         * 3:    D              1 char, 0 chars below, 5 chars above
         * And ABFCED as result.
         *
         * PAYPALISHIRING (14 chars) with 3 rows maps to zigzag
         * 0: P   A   H   N     4 chars per 0 row, 3 chars lower, 0 char lower
         * 1:  A P L S I I G    7 chars par 1 row, 1 char lower, 1 chars lower
         * 2:   Y   I   R       3 chars per 2 row, 0 chars lower, 3 char lower
         * And PAHNAPLSIIGYIR as result.
         *
         * PAYPAL (6 chars) with 2 rows maps to
         * 0: P Y A             3 chars per 0 row, 1 char lower, 0 chars upper
         * 1:  A P L            3 chars per 1 row, 0 chars lower, 1 chars upper
         * And PYAAPL as result.
         */
        @Override
        public String convert(String s, int numRows) {
            if (s == null) {
                return null;
            }
            if (numRows < 1) {
                return null;
            }

            if (s.length() <= 1) {
                return s;
            }
            if (numRows == 1) {
                return s;
            }

            char[] tC = new char[s.length()];
            int tcIdx = 0;

            int upperCharsCnt, lowerCharsCnt;
            int newIdx;
            int additive;

            for (int i = 0; i < numRows; i++) {
                newIdx = i;

                upperCharsCnt = upperCharsCntForRow(i);
                lowerCharsCnt = lowerCharsCntForRow(i, numRows);
                if (i == 0) {
                    additive = lowerCharsCnt;
                } else if (i == numRows - 1) {
                    additive = upperCharsCnt;
                } else {
                    additive = 0;
                }

                while (tcIdx < s.length() && newIdx < s.length()) {
                    if (i != 0 && i != numRows - 1) {
                        additive = (additive == lowerCharsCnt) ? upperCharsCnt : lowerCharsCnt;
                    }

                    tC[tcIdx++] = s.charAt(newIdx);
                    newIdx += additive + 1;
                }
            }

            return new String(tC);
        }

        /**
         * Amount of chars above the pair of chars within this row.
         */
        public static int upperCharsCntForRow(int rowNum) {
            return (rowNum > 1) ? (1 + (rowNum - 1) * 2) : rowNum;
        }

        /**
         * Amount of chars below between chars of this row.
         */
        public static int lowerCharsCntForRow(int rowNum, int rowsCnt) {
            return (rowNum < rowsCnt - 2)
                ? (1 + (rowsCnt - 2 - rowNum) * 2)
                : (rowNum == rowsCnt - 2 ? 1 : 0);
        }

    }

    @SuppressWarnings("WeakerAccess")
    private static class Solution2 implements Solution {

        @Override
        public String convert(String s, int numRows) {
            if (s == null) {
                return null;
            }
            if (numRows < 1) {
                return null;
            }

            // preprocess

            if (s.length() <= 1) {
                return s;
            }
            if (numRows == 1) {
                return s;
            }

            // prepare storage

            final List<List<Character>> rows = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                rows.add(new ArrayList<>());
            }

            // process

            int currentRowIdx = -1;
            int additive = 1;

            for (int currentCharIdx = 0; currentCharIdx < s.length(); currentCharIdx++) {
                if (currentRowIdx == 0) {
                    additive = 1;
                } else if (currentRowIdx == numRows - 1) {
                    additive = -1;
                }
                currentRowIdx += additive;

                rows.get(currentRowIdx).add(s.charAt(currentCharIdx));
            }

            // collect

            final char[] tC = new char[s.length()];
            int tcIdx = 0;

            for (List<Character> row : rows) {
                for (Character character : row) {
                    tC[tcIdx++] = character;
                }
            }

            return new String(tC);
        }

    }

    public static void main(String[] args) {
        assert Solution1.upperCharsCntForRow(0) == 0;
        assert Solution1.upperCharsCntForRow(1) == 1;

        assert Solution1.upperCharsCntForRow(0) == 0;
        assert Solution1.upperCharsCntForRow(1) == 1;
        assert Solution1.upperCharsCntForRow(2) == 3;

        assert Solution1.upperCharsCntForRow(0) == 0;
        assert Solution1.upperCharsCntForRow(1) == 1;
        assert Solution1.upperCharsCntForRow(2) == 3;
        assert Solution1.upperCharsCntForRow(3) == 5;

        assert Solution1.upperCharsCntForRow(0) == 0;
        assert Solution1.upperCharsCntForRow(1) == 1;
        assert Solution1.upperCharsCntForRow(2) == 3;
        assert Solution1.upperCharsCntForRow(3) == 5;
        assert Solution1.upperCharsCntForRow(4) == 7;

        assert Solution1.lowerCharsCntForRow(0, 2) == 1;
        assert Solution1.lowerCharsCntForRow(1, 2) == 0;

        assert Solution1.lowerCharsCntForRow(0, 3) == 3;
        assert Solution1.lowerCharsCntForRow(1, 3) == 1;
        assert Solution1.lowerCharsCntForRow(2, 3) == 0;

        assert Solution1.lowerCharsCntForRow(0, 4) == 5;
        assert Solution1.lowerCharsCntForRow(1, 4) == 3;
        assert Solution1.lowerCharsCntForRow(2, 4) == 1;
        assert Solution1.lowerCharsCntForRow(3, 4) == 0;

        assert Solution1.lowerCharsCntForRow(0, 5) == 7;
        assert Solution1.lowerCharsCntForRow(1, 5) == 5;
        assert Solution1.lowerCharsCntForRow(2, 5) == 3;
        assert Solution1.lowerCharsCntForRow(3, 5) == 1;
        assert Solution1.lowerCharsCntForRow(4, 5) == 0;

        runTestSet(new Solution1());
        runTestSet(new Solution2());
    }

    private static void runTestSet(final Solution solution) {
        assert solution.convert(null, 0) == null;
        assert solution.convert("whatever", 0) == null;
        assert "".equals(solution.convert("", 1));
        assert "a".equals(solution.convert("a", 1));

        assert "PYAAPL".equals(solution.convert("PAYPAL", 2));
        assert "PAHNAPLSIIGYIR".equals(solution.convert("PAYPALISHIRING", 3));
        assert "KLBNOOAMDLMRBYYL".equals(solution.convert("KNDYLOLOMYRABMBL", 4));
        assert "KDKNNYYNDKKDDYNY".equals(solution.convert("KNDYKNDYKNDYKNDY", 4));
        assert "ABFCED".equals(solution.convert("ABCDEF", 4));
    }

}
