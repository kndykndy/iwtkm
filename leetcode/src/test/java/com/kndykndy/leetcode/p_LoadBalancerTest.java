package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p_LoadBalancer.Solution;
import com.kndykndy.leetcode.p_LoadBalancer.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p_LoadBalancerTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertTrue(solution.solution(new int[]{1, 3, 4, 2, 2, 2, 1, 1, 2}));
            assertFalse(solution.solution(new int[]{1, 1, 1, 1, 1, 1}));
        }
    }

    @Test
    void test2() {
        final int[] ints = new int[20000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (i % 2 == 0) ? 1 : 2;
        }

        for (Solution solution : solutions) {
            // Given A = [1, 2, 1, 2, ..., 1, 2] of length 20,000
            assertTrue(solution.solution(ints));
        }
    }
}
