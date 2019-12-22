package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p8_StringToIntegerAtoi.Solution;
import com.kndykndy.leetcode.p8_StringToIntegerAtoi.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p8_StringToIntegerAtoiTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(solution.myAtoi(null), 0);
            assertEquals(solution.myAtoi(""), 0);
            assertEquals(solution.myAtoi("  lol"), 0);
            assertEquals(solution.myAtoi("  -lol"), 0);
            assertEquals(solution.myAtoi("  +lol"), 0);
            assertEquals(solution.myAtoi("  lol1"), 0);

            assertEquals(solution.myAtoi("  1  "), 1);
            assertEquals(solution.myAtoi("  1"), 1);
            assertEquals(solution.myAtoi("  +1 "), 1);
            assertEquals(solution.myAtoi("  -1 "), -1);
            assertEquals(solution.myAtoi("  -1lol"), -1);
            assertEquals(solution.myAtoi("  -123lol"), -123);
            assertEquals(solution.myAtoi("    10522545459"), 2147483647);
            assertEquals(solution.myAtoi("9223372036854775809"), 2147483647);

            assertEquals(solution.myAtoi("2147483647"), 2147483647);
            assertEquals(solution.myAtoi("2147483648"), 2147483647);
            assertEquals(solution.myAtoi("-2147483648"), -2147483648);
            assertEquals(solution.myAtoi("-2147483649"), -2147483648);
        }
    }
}
