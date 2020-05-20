package com.kndykndy.leetcode;

public class p010_RegularExpressionMatching {

    interface Solution {

        /**
         * '.' Matches any single character.
         * '*' Matches zero or more of the preceding element.
         */
        boolean isMatch(String s, String p);
    }

    public static class OptimalSolution implements Solution {

        @Override
        public boolean isMatch(String s, String p) {
            /*
                   a * b . c d
                 T   T         -- we always set [0;0] as True; second T comes out of pre-fill and says that a* matches an empty string
               a   T T         -- T1: a==a; T2: p==*, prev p == s, take [i-1;j]
               a   T T         -- same as prev
               b       T       -- because b==b
               b       T       -- same as prev
               c         T T   -- T1: p==., take [i-1;j-1]; T2: c==c
               d             T -- d==d; ANSWER is taken from this point, True
             */

            if (s == null || p == null) {
                return false;
            }

            final int sLen = s.length(), pLen = p.length();
            final boolean[][] m = new boolean[sLen + 1][pLen + 1];
            m[0][0] = true;
            for (int i = 1; i < m[0].length; i++) {
                if (p.charAt(i - 1) == '*') {
                    m[0][i] = m[0][i - 2];
                }
            }

            char sChar, pChar;
            for (int i = 1; i <= sLen; i++) {
                for (int j = 1; j <= pLen; j++) {
                    sChar = s.charAt(i - 1);
                    pChar = p.charAt(j - 1);

                    if (pChar == sChar || pChar == '.') {
                        m[i][j] = m[i - 1][j - 1];
                    } else if (pChar == '*') {
                        m[i][j] = m[i][j - 2];
                        if (p.charAt(j - 2) == sChar || p.charAt(j - 2) == '.') {
                            m[i][j] = m[i][j] || m[i - 1][j];
                        }
                    } else {
                        m[i][j] = false;
                    }
                }
            }

            return m[sLen][pLen];
        }
    }
}
