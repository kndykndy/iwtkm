package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p1046_LastStoneWeight.Solution;
import com.kndykndy.leetcode.p1046_LastStoneWeight.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p1046_LastStoneWeightTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(1, solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        }
    }
}
