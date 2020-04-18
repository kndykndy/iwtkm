package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p064_MinimumPathSum.Solution;
import com.kndykndy.leetcode.p064_MinimumPathSum.Solution1;
import com.kndykndy.leetcode.util.Utils;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p064_MinimumPathSumTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(5, solution.minPathSum(Utils.strTo2DArray("[[1,3],[5,1]]")));
            assertEquals(7, solution.minPathSum(Utils.strTo2DArray("[[1,3,1],[1,5,1],[4,2,1]]")));
        }
    }
}
