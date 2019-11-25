package main.java.com.kndykndy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode #3 ~ Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * 11 Mar 2018
 *
 * Problem statement:
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
 * substring, "pwke" is a subsequence and not a substring.
 */
public class p3_LengthOfLongestSubstring {

    @SuppressWarnings("WeakerAccess")
    private static class Solution {

        public int lengthOfLongestSubstring(String s) {
            if (s == null || "".equals(s.trim())) {
                return 0;
            }

            final int sLength = s.length();
            int currentIdx = 0;
            int longestSequenceLength = 0;

            final Deque<Character> longestSequence = new ArrayDeque<>();
            char currentChar;

            while (currentIdx < sLength) {
                currentChar = s.charAt(currentIdx);

                if (!longestSequence.isEmpty()) {
                    if (longestSequence.contains(currentChar)) {
                        while (longestSequence.peekFirst() != currentChar) {
                            longestSequence.pollFirst();
                        }
                        longestSequence.pollFirst(); // removes first item itself
                    }
                    longestSequence.add(currentChar);
                } else {
                    longestSequence.add(currentChar);
                }

                if (longestSequence.size() > longestSequenceLength) {
                    longestSequenceLength = longestSequence.size();
                }

                ++currentIdx;
            }

            return longestSequenceLength;
        }

    }

    @SuppressWarnings("AssertWithSideEffects")
    public static void main(String[] args) {
        assert new Solution().lengthOfLongestSubstring("") == 0;
        assert new Solution().lengthOfLongestSubstring("c") == 1;

        assert new Solution().lengthOfLongestSubstring("abcabcbb") == 3;

        assert new Solution().lengthOfLongestSubstring("bbbbb") == 1;

        assert new Solution().lengthOfLongestSubstring("pwwkew") == 3;

        assert new Solution().lengthOfLongestSubstring("dvdf") == 3;
    }

}
