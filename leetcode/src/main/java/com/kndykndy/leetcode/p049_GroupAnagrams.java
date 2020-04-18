package com.kndykndy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class p049_GroupAnagrams {

    interface Solution {

        List<List<String>> groupAnagrams(String[] strs);
    }

    /**
     * Time O(nlogn), space O(n).
     */
    public static class Solution1 implements Solution {

        @Override
        public List<List<String>> groupAnagrams(String[] strs) {
            final Map<String, List<String>> map = new HashMap<>();

            char[] chars;

            for (String anagram : strs) {
                chars = anagram.toCharArray();
                Arrays.sort(chars);

                final String sortedAnagram = new String(chars);
                if (map.containsKey(sortedAnagram)) {
                    map.get(sortedAnagram).add(anagram);
                } else {
                    map.put(sortedAnagram, new LinkedList<>(Collections.singletonList(anagram)));
                }
            }

            return new ArrayList<>(map.values());
        }
    }
}
