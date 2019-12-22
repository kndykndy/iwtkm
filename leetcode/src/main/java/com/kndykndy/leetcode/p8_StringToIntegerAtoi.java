package com.kndykndy.leetcode;

/**
 * Leetcode #8 ~ String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi
 *
 * 17 Mar 2018
 *
 * Problem statement:
 * Implement atoi to convert a string to an integer. Hint: Carefully consider all possible input
 * cases. If you want a challenge, please do not see below and ask yourself what are the possible
 * input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You
 * are responsible to gather all the input requirements up front.
 *
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional initial
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a
 * numerical value.
 * The string can contain additional characters after those that form the integral number, which
 * are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if
 * no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out
 * of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class p8_StringToIntegerAtoi {

    interface Solution {

        int myAtoi(String str);
    }

    public static class Solution1 implements Solution {

        @Override
        public int myAtoi(String str) {
            if (str == null || "".equals(str.trim())) {
                return 0;
            }

            str = str.trim();

            int startIdx = 0;
            int nextIdx;
            boolean isNegative = false;

            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                startIdx = 1;
                isNegative = str.charAt(0) == '-';
            }

            // find first non-digit

            nextIdx = startIdx;
            while (nextIdx < str.length() && "0123456789".indexOf(str.charAt(nextIdx)) != -1) {
                nextIdx++;
            }
            if (nextIdx == startIdx) { // i.e. no digits at all
                return 0;
            }
            if (nextIdx - startIdx > 10) {
                return !isNegative ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // count

            long result = 0;

            long factor = 1;
            int currentDigit;

            for (int i = nextIdx - 1; i >= startIdx; i--) {
                currentDigit = str.charAt(i) - '0';

                result += currentDigit * factor;
                factor *= 10L;
            }

            if (isNegative) {
                result = -result;
            }

            if (result > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
            } else if (result < Integer.MIN_VALUE) {
                result = Integer.MIN_VALUE;
            }

            return (int) result;
        }
    }
}
