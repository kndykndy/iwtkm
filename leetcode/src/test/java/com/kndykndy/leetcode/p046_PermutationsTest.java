package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p046_Permutations.Solution;
import com.kndykndy.leetcode.p046_Permutations.Solution1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p046_PermutationsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            final List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
            assertEquals(6, result.size());
            assertTrue(result.contains(Arrays.asList(1, 2, 3)));
            assertTrue(result.contains(Arrays.asList(1, 3, 2)));
            assertTrue(result.contains(Arrays.asList(2, 1, 3)));
            assertTrue(result.contains(Arrays.asList(2, 3, 1)));
            assertTrue(result.contains(Arrays.asList(3, 2, 1)));
            assertTrue(result.contains(Arrays.asList(3, 1, 2)));
        }
    }
}
