package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p013_RomanToInteger.Solution;
import com.kndykndy.leetcode.p013_RomanToInteger.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p013_RomanToIntegerTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(3, solution.romanToInt("III"));
            assertEquals(4, solution.romanToInt("IV"));
            assertEquals(9, solution.romanToInt("IX"));
            assertEquals(58, solution.romanToInt("LVIII"));
        }
    }
}
