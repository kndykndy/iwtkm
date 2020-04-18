package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p044_WildcardMatching.Solution;
import com.kndykndy.leetcode.p044_WildcardMatching.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p044_WildcardMatchingTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertTrue(solution.isMatch("", ""));
            assertTrue(solution.isMatch("", "*"));
            assertTrue(solution.isMatch("adceb", "*a*b"));
            assertTrue(solution.isMatch("ab", "?*"));
            assertTrue(solution.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));

            assertFalse(solution.isMatch(null, null));
            assertFalse(solution.isMatch("aa", "a"));
            assertFalse(solution.isMatch("", "?"));
            assertFalse(solution.isMatch("acdcb", "a*c?b"));
        }
    }
}
