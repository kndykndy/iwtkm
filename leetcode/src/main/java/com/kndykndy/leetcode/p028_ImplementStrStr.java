package com.kndykndy.leetcode;

public class p028_ImplementStrStr {

    interface Solution {

        int strStr(String haystack, String needle);
    }

    public static class Solution1 implements Solution {

        @Override
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) {
                return -1;
            }
            if (haystack.length() == 0) {
                if (needle.length() > 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
            if (needle.length() == 0) {
                return 0;
            }

            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    int k = 1;
                    while (i + k < haystack.length() && k < needle.length()) {
                        if (haystack.charAt(i + k) != needle.charAt(k)) {
                            break;
                        }
                        k++;
                    }
                    if (k == needle.length()) {
                        return i;
                    }
                }
            }

            return -1;
        }
    }

    public static class Solution2 implements Solution {

        @Override
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null || needle.length() > haystack.length()) {
                return -1;
            }
            if (haystack.length() == 0 || needle.length() == 0) {
                return 0;
            }

            int i = 0;
            while (i < haystack.length() - needle.length() + 1) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    int k = 0;
                    while (i < haystack.length()
                        && k < needle.length()
                        && haystack.charAt(i) == needle.charAt(k)) {
                        i++;
                        k++;
                    }
                    if (k == needle.length()) {
                        return i - k;
                    }
                    i -= (k - 1);
                } else {
                    i++;
                }
            }

            return -1;
        }
    }
}
