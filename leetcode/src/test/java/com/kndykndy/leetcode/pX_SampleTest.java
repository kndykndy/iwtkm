package com.kndykndy.leetcode;

import com.kndykndy.leetcode.pX_Sample.BruteForceSolution;
import com.kndykndy.leetcode.pX_Sample.Solution;
import com.kndykndy.leetcode.pX_Sample.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class pX_SampleTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new BruteForceSolution(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
        }
    }
}
