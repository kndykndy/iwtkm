package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p268_MissingNumber.Solution;
import com.kndykndy.leetcode.p268_MissingNumber.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p268_MissingNumberTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(1, solution.missingNumber(new int[]{0}));
            assertEquals(0, solution.missingNumber(new int[]{1}));
            assertEquals(2, solution.missingNumber(new int[]{0, 1}));
            assertEquals(2, solution.missingNumber(new int[]{3, 0, 1}));
            assertEquals(8, solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        }
    }
}
