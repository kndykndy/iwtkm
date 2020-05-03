package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p020_ValidParenthesis.Solution;
import com.kndykndy.leetcode.p020_ValidParenthesis.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class p020_ValidParenthesisTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertTrue(solution.isValid("()"));
            assertTrue(solution.isValid("(){}[]"));
            assertTrue(solution.isValid("{[]}"));
            assertFalse(solution.isValid("(]"));
            assertFalse(solution.isValid("([)]"));
        }
    }
}
