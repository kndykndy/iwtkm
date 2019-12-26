package com.kndykndy.leetcode;

public class p151_ReverseWordsString {

    interface Solution {

        String reverseWords(String s);
    }

    public static class BruteForceSolution implements Solution {

        @Override
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            final StringBuilder sb = new StringBuilder();
            StringBuilder tempsb = new StringBuilder();

            int k = 0;
            while (k < s.length()) {
                if (s.charAt(k) != ' ') {
                    tempsb.append(s.charAt(k));
                } else {
                    if (tempsb.length() != 0) {
                        if (sb.length() != 0) {
                            sb.insert(0, ' ');
                        }
                        sb.insert(0, tempsb.toString());
                        tempsb = new StringBuilder();
                    }
                }

                ++k;
            }

            if (tempsb.length() != 0) {
                if (sb.length() != 0) {
                    sb.insert(0, ' ');
                }
                sb.insert(0, tempsb.toString());
            }
            return sb.toString();
        }
    }
}
