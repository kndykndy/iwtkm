package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p3_LengthOfLongestSubstring.Solution;
import com.kndykndy.leetcode.p3_LengthOfLongestSubstring.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p3_LengthOfLongestSubstringTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(0, solution.lengthOfLongestSubstring(""));
            assertEquals(1, solution.lengthOfLongestSubstring("c"));
            assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
            assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
            assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
            assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
        }
    }
}
