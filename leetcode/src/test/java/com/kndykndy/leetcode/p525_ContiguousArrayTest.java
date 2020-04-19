package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p525_ContiguousArray.BruteForceSolution;
import com.kndykndy.leetcode.p525_ContiguousArray.Solution;
import com.kndykndy.leetcode.p525_ContiguousArray.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p525_ContiguousArrayTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new BruteForceSolution(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(2, solution.findMaxLength(new int[]{0, 1}));
            assertEquals(2, solution.findMaxLength(new int[]{0, 1, 0}));
            assertEquals(2, solution.findMaxLength(new int[]{0, 1, 1}));
            assertEquals(2, solution.findMaxLength(new int[]{0, 1, 1, 1}));
            assertEquals(4, solution.findMaxLength(new int[]{0, 0, 0, 0, 1, 1}));
            assertEquals(4, solution.findMaxLength(new int[]{0, 1, 0, 0, 1, 0}));
            assertEquals(2, solution.findMaxLength(new int[]{1, 0, 0, 0, 1, 0}));
            assertEquals(6, solution.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
            assertEquals(4, solution.findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}));
            assertEquals(68, solution.findMaxLength(
                new int[]{0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0,
                    0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1,
                    0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0,
                    1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1}));
        }
    }
}
