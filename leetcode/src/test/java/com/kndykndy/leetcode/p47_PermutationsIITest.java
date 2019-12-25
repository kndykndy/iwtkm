package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p47_PermutationsII.Solution;
import com.kndykndy.leetcode.p47_PermutationsII.Solution1;
import com.kndykndy.leetcode.p47_PermutationsII.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p47_PermutationsIITest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            final List<List<Integer>> result = solution.permuteUnique(new int[]{1, 1, 2});
            assertEquals(3, result.size());
            assertTrue(result.contains(Arrays.asList(1, 1, 2)));
            assertTrue(result.contains(Arrays.asList(2, 1, 1)));
            assertTrue(result.contains(Arrays.asList(1, 2, 1)));
        }
    }
}
