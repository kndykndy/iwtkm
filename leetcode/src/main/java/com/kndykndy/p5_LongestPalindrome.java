package main.java.com.kndykndy;

/**
 * Leetcode #5 ~ Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring
 *
 * 1 Mar 2018
 *
 * Problem statement:
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 * length of s is 1000.
 *
 * Examples:
 * Input: "babad", output: "bab", note: "aba" is also a valid answer.
 * Input: "cbbd", output: "bb"
 */
public class p5_LongestPalindrome {

    @SuppressWarnings("WeakerAccess")
    private static class Solution {

        public String longestPalindrome(String s) {
            if (s == null || "".equals(s)) {
                return "";
            }

            String longestPalindrome = "";
            String tempStr;
            for (int i = 0; i < s.length(); i++) {
                tempStr = oddPalindrome(s, i);
                if (tempStr != null && tempStr.length() > longestPalindrome.length()) {
                    longestPalindrome = tempStr;
                }
                tempStr = evenPalindrome(s, i);
                if (tempStr != null && tempStr.length() > longestPalindrome.length()) {
                    longestPalindrome = tempStr;
                }
            }

            return longestPalindrome;
        }

        private static String oddPalindrome(String s, int pivotCharIdx) {
            if (s == null || "".equals(s)) {
                return null;
            }
            if (pivotCharIdx < 0 || pivotCharIdx > s.length()) {
                return null;
            }

            int i = 0;
            while (i < s.length()
                && pivotCharIdx - i - 1 >= 0
                && pivotCharIdx + i + 1 <= s.length() - 1
                && s.charAt(pivotCharIdx - i - 1) == s.charAt(pivotCharIdx + i + 1)) {
                i++;
            }

            return s.substring(pivotCharIdx - i, pivotCharIdx + i + 1);
        }

        public static String evenPalindrome(String s, int pivotCharIdx) {
            if (s == null || "".equals(s) || s.length() < 2) {
                return null;
            }
            if (pivotCharIdx < 0 || pivotCharIdx > s.length() - 1) {
                return null;
            }

            int i = -1;
            while (i < s.length()
                && pivotCharIdx - i - 1 >= 0
                && pivotCharIdx + 1 + i + 1 <= s.length() - 1
                && s.charAt(pivotCharIdx - i - 1) == s.charAt(pivotCharIdx + 1 + i + 1)) {
                i++;
            }

            if (i == -1) {
                return null;
            }

            return s.substring(pivotCharIdx - i, pivotCharIdx + 1 + i + 1);
        }

    }

    @SuppressWarnings("AssertWithSideEffects")
    public static void main(String[] args) {
        // test odd palindrome

        assert Solution.oddPalindrome(null, 0) == null;
        assert Solution.oddPalindrome("", 0) == null;
        assert "b".equals(Solution.oddPalindrome("b", 0));
        assert "b".equals(Solution.oddPalindrome("ba", 0));
        assert "a".equals(Solution.oddPalindrome("ba", 1));
        assert "bab".equals(Solution.oddPalindrome("bab", 1));
        assert "bab".equals(Solution.oddPalindrome("baba", 1));
        assert "aba".equals(Solution.oddPalindrome("baba", 2));
        assert "babab".equals(Solution.oddPalindrome("babab", 2));
        assert "aba".equals(Solution.oddPalindrome("babad", 2));

        // test even palindrome

        assert Solution.evenPalindrome(null, 0) == null;
        assert Solution.evenPalindrome("", 0) == null;
        assert Solution.evenPalindrome("l", 0) == null;
        assert Solution.evenPalindrome("lc", 0) == null;
        assert Solution.evenPalindrome("lcc", 0) == null;
        assert "cc".equals(Solution.evenPalindrome("lcc", 1));
        assert Solution.evenPalindrome("lccl", 0) == null;
        assert "lccl".equals(Solution.evenPalindrome("lccl", 1));
        assert "cc".equals(Solution.evenPalindrome("lccb", 1));

        // test palindrome lengths

        assert "".equals(new Solution().longestPalindrome(""));
        assert "c".equals(new Solution().longestPalindrome("c"));
        assert "cac".equals(new Solution().longestPalindrome("cac"));
        assert "bab".equals(new Solution().longestPalindrome("babad"));
        assert "bb".equals(new Solution().longestPalindrome("cbbd"));
    }

}
