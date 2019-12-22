package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p7_ReverseInteger.Solution;
import com.kndykndy.leetcode.p7_ReverseInteger.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p7_ReverseIntegerTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(solution.reverse(Integer.MAX_VALUE), 0);
            assertEquals(solution.reverse(-Integer.MAX_VALUE), 0);
            assertEquals(solution.reverse(Integer.MIN_VALUE), 0);
            assertEquals(solution.reverse(123), 321);
            assertEquals(solution.reverse(-123), -321);
            assertEquals(solution.reverse(120), 21);
        }
    }
}
