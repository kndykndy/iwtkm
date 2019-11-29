package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p11_ContainerWithMostWater.Solution;
import com.kndykndy.leetcode.p11_ContainerWithMostWater.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p11_ContainerWithMostWaterTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(1, solution.maxArea(new int[]{1, 100}));
            assertEquals(50, solution.maxArea(new int[]{1, 100, 50}));
            assertEquals(7, solution.maxArea(new int[]{1, 1, 1, 1, 1, 2, 1, 5}));
            assertEquals(49, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        }
    }
}
