package main.java.com.kndykndy;

/**
 * Leetcode #9 ~ Palindrome Number
 * https://leetcode.com/problems/palindrome-number
 *
 * 18 Mar 2018
 *
 * Problem statement:
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Example:
 * 13 is not a palindrome, 131 and 1331 are palindromes.
 *
 * Questions and assumptions:
 * What if number is negative? No, it can't be, return false.
 * What is reversed number overflows? If it overflows it still must be checked.
 */
public class p009_PalindromeNumber {

    @SuppressWarnings("WeakerAccess")
    private static class Solution {

        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            int tempX = x;

            long result = 0;

            int tensFactor = 1;
            int currentDigit;

            while (tempX != 0) {
                currentDigit = tempX % 10; // gives current digit (remainder)
                tempX /= 10; // lowers input num by 10 with, dividing by whole

                result = result * tensFactor + currentDigit;
                if (tensFactor == 1) {
                    tensFactor *= 10;
                }
            }

            return result <= Integer.MAX_VALUE && result == x;
        }

    }

    public static void main(String[] args) {
        assert !new Solution().isPalindrome(-1);
        assert !new Solution().isPalindrome(-111);
        assert !new Solution().isPalindrome(10);
        assert !new Solution().isPalindrome(122);

        assert new Solution().isPalindrome(0);
        assert new Solution().isPalindrome(11);
        assert new Solution().isPalindrome(222);
        assert new Solution().isPalindrome(3113);
        assert new Solution().isPalindrome(12321);
        assert new Solution().isPalindrome(999999999);
        assert new Solution().isPalindrome(2147447412);
    }

}
