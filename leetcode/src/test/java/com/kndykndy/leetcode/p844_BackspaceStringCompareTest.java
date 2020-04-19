package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p844_BackspaceStringCompare.Solution;
import com.kndykndy.leetcode.p844_BackspaceStringCompare.Solution1;
import com.kndykndy.leetcode.p844_BackspaceStringCompare.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p844_BackspaceStringCompareTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertTrue(solution.backspaceCompare("a", "a"));
            assertFalse(solution.backspaceCompare("a", "b"));
            assertFalse(solution.backspaceCompare("a", "#"));
            assertTrue(solution.backspaceCompare("#", "#"));
            assertTrue(solution.backspaceCompare("##", "##"));
            assertTrue(solution.backspaceCompare("ab#c", "ad#c"));
            assertTrue(solution.backspaceCompare("ab##", "c#d#"));
            assertTrue(solution.backspaceCompare("a##c", "#a#c"));
            assertFalse(solution.backspaceCompare("a#c", "b"));
            assertTrue(solution.backspaceCompare("y#fo##f", "y#f#o##f"));
            assertTrue(solution.backspaceCompare("bxj##tw", "bxo#j##tw"));
            assertFalse(solution.backspaceCompare("nzp#o#g", "nzp#o##g"));
        }
    }
}
