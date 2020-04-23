package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p201_BitwiseANDOfNumbersRange.BruteForceSolution;
import com.kndykndy.leetcode.p201_BitwiseANDOfNumbersRange.Solution;
import com.kndykndy.leetcode.p201_BitwiseANDOfNumbersRange.Solution1;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p201_BitwiseANDOfNumbersRangeTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new BruteForceSolution(), new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(0, solution.rangeBitwiseAnd(0, 1));
            assertEquals(4, solution.rangeBitwiseAnd(5, 7));
            assertEquals(0, solution.rangeBitwiseAnd(20000, 2147483647));
            assertEquals(2147483646, solution.rangeBitwiseAnd(2147483646, 2147483647));
        }
    }
}
