package main.java.com.kndykndy;

/**
 * Leetcode #7 ~ Reverse Integer
 * https://leetcode.com/problems/reverse-integer
 *
 * 17 Mar 2018
 *
 * Problem statement:
 * Given a 32-bit signed integer, reverse digits of an integer. Assume we are dealing with an
 * environment which could only hold integers within the 32-bit signed integer range. For the
 * purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * Examples:
 * Input: 123; Output: 321
 * Input: -123; Output: -321
 * Input: 120; Output: 21;
 *
 * Solution (e.g. for 123 -> 321):
 * 3 -> 0*1+3   -> 3
 * 2 -> 3*10+2  -> 32
 * 1 -> 32*10+1 -> 321
 */
public class p007_ReverseInteger {

    @SuppressWarnings("WeakerAccess")
    private static class Solution {

        public int reverse(int x) {
            long result = 0;

            int tensFactor = 1;
            int currentDigit;

            while (x != 0) {
                currentDigit = x % 10; // gives current digit (remainder)
                x = x / 10; // lowers input num by 10 with, dividing by whole

                result = result * tensFactor + currentDigit;
                if (tensFactor == 1) {
                    tensFactor *= 10;
                }
            }

            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                result = 0;
            }

            return (int) result;
        }

    }

    public static void main(String[] args) {
        assert new Solution().reverse(Integer.MAX_VALUE) == 0;
        assert new Solution().reverse(-Integer.MAX_VALUE) == 0;
        assert new Solution().reverse(Integer.MIN_VALUE) == 0;

        assert new Solution().reverse(123) == 321;
        assert new Solution().reverse(-123) == -321;
        assert new Solution().reverse(120) == 21;
    }

}
