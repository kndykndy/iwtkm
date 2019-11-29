package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.kndykndy.leetcode.p238_ProductArrayExceptSelf.Solution;
import com.kndykndy.leetcode.p238_ProductArrayExceptSelf.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p238_ProductArrayExceptSelfTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertArrayEquals(new int[]{1, 1}, solution.productExceptSelf(new int[]{1, 1}));
            assertArrayEquals(
                new int[]{24, 12, 8, 6},
                solution.productExceptSelf(new int[]{1, 2, 3, 4}));
        }
    }
}
