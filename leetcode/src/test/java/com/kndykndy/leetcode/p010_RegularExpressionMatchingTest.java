package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p010_RegularExpressionMatching.OptimalSolution;
import com.kndykndy.leetcode.p010_RegularExpressionMatching.Solution;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p010_RegularExpressionMatchingTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new OptimalSolution());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertTrue(solution.isMatch("", ""));
            assertTrue(solution.isMatch("aa", "aa"));
            assertTrue(solution.isMatch("aa", "a*"));
            assertTrue(solution.isMatch("aa", ".*"));
            assertTrue(solution.isMatch("ab", ".*"));
            assertTrue(solution.isMatch("aab", "a*a*b"));
            assertTrue(solution.isMatch("aabbcd", "a*b.cd"));
            assertTrue(solution.isMatch("aaaa", "a*a*"));
            assertTrue(solution.isMatch("aaaa", "aaa*"));
            assertTrue(solution.isMatch("aaaa", "aa*a"));
            assertTrue(solution.isMatch("aaaa", "a*aa"));
            assertTrue(solution.isMatch("aaaa", "a*a*a"));
            assertTrue(solution.isMatch("aaabbbccc", ".*.*..*"));

            assertFalse(solution.isMatch("aa", "a"));
            assertFalse(solution.isMatch("aaa", "aa"));
        }
    }
}
