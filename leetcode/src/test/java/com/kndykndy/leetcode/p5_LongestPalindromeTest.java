package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p5_LongestPalindrome.Solution;
import com.kndykndy.leetcode.p5_LongestPalindrome.BruteForceSolution;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p5_LongestPalindromeTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new BruteForceSolution());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(solution.longestPalindrome(""), "");
            assertEquals(solution.longestPalindrome("c"), "c");
            assertEquals(solution.longestPalindrome("cac"), "cac");
            assertEquals(solution.longestPalindrome("babad"), "bab");
            assertEquals(solution.longestPalindrome("cbbd"), "bb");
        }
    }
}
