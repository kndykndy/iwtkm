package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p055_JumpGame.BruteForceSolution;
import com.kndykndy.leetcode.p055_JumpGame.DpMemoizationSolution;
import com.kndykndy.leetcode.p055_JumpGame.Solution;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p055_JumpGameTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new BruteForceSolution(), new DpMemoizationSolution());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertTrue(solution.canJump(new int[]{0}));
            assertTrue(solution.canJump(new int[]{1}));
            assertTrue(solution.canJump(new int[]{2, 3, 1, 1, 4}));
            assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 4}));
            assertTrue(solution.canJump(new int[]{1, 2, 3}));
            assertTrue(solution.canJump(new int[]{2, 3, 0, 1, 4}));
            assertTrue(solution.canJump(new int[]{1, 2, 1, 1, 1}));
        }
    }
}
