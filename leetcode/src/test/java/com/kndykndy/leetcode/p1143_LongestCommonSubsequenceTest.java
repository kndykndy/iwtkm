package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p1143_LongestCommonSubsequence.Solution;
import com.kndykndy.leetcode.p1143_LongestCommonSubsequence.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p1143_LongestCommonSubsequenceTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(3, solution.longestCommonSubsequence("abcde", "ace"));
            assertEquals(3, solution.longestCommonSubsequence("abc", "abc"));
            assertEquals(0, solution.longestCommonSubsequence("abc", "def"));
        }
    }
}
