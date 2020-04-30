package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p678_ValidParenthesisString.OptimalSolution;
import com.kndykndy.leetcode.p678_ValidParenthesisString.Solution;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p678_ValidParenthesisStringTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new OptimalSolution());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertTrue(solution.checkValidString(""));
            assertTrue(solution.checkValidString("(*"));
            assertTrue(solution.checkValidString("*)"));
            assertTrue(solution.checkValidString("()"));
            assertTrue(solution.checkValidString("(*)"));
            assertTrue(solution.checkValidString("(*))"));
            assertTrue(solution.checkValidString("(*()"));
            assertTrue(solution.checkValidString("(**)"));

            assertFalse(solution.checkValidString("("));
            assertFalse(solution.checkValidString(")"));
            assertFalse(solution.checkValidString(")*"));
            assertFalse(
                solution.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        }
    }
}
