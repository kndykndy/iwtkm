package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p46_Permutations.Solution;
import com.kndykndy.leetcode.p46_Permutations.Solution1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p46_PermutationsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            List<List<Integer>> result;
            result = solution.permute(new int[]{1, 2, 3});
            assertEquals(Arrays.asList(1, 2, 3), result.get(0));
            assertEquals(Arrays.asList(1, 3, 2), result.get(1));
            assertEquals(Arrays.asList(2, 1, 3), result.get(2));
            assertEquals(Arrays.asList(2, 3, 1), result.get(3));
            assertEquals(Arrays.asList(3, 2, 1), result.get(4));
            assertEquals(Arrays.asList(3, 1, 2), result.get(5));
        }
    }
}
