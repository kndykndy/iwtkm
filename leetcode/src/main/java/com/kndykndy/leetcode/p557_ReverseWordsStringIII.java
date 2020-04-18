package com.kndykndy.leetcode;

public class p557_ReverseWordsStringIII {

    interface Solution {

        String reverseWords(String s);
    }

    public static class Solution1 implements Solution {

        @Override
        public String reverseWords(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }

            final StringBuilder sb = new StringBuilder();
            StringBuilder tempsb = new StringBuilder();

            int k = 0;
            while (k < s.length()) {
                if (s.charAt(k) != ' ') {
                    tempsb.insert(0, s.charAt(k));
                } else {
                    sb.append(tempsb.toString()).append(' ');
                    tempsb = new StringBuilder();
                }

                ++k;
            }

            if (tempsb.length() != 0) {
                sb.append(tempsb.toString());
            }
            return sb.toString();
        }
    }
}
