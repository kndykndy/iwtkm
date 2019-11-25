package com.kndykndy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.kndykndy.p1_TwoSum.Solution;
import com.kndykndy.p1_TwoSum.Solution1;
import com.kndykndy.p1_TwoSum.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p1_TwoSumTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertNull(solution.twoSum(null, 0));
        }
    }

    @Test
    void test2() {
        for (Solution solution : solutions) {
            assertNull(solution.twoSum(new int[]{0}, 0));
        }
    }

    @Test
    void test3() {
        for (Solution solution : solutions) {
            assertNull(solution.twoSum(new int[]{1, 2}, 2));
        }
    }

    @Test
    void test4() {
        for (Solution solution : solutions) {
            int[] indexes = solution.twoSum(new int[]{1, 2}, 3);
            assertNotNull(indexes);
            assertEquals(2, indexes.length);
            assertArrayEquals(new int[]{0, 1}, indexes);
        }
    }

    @Test
    void test5() {
        for (Solution solution : solutions) {
            int[] indexes = solution.twoSum(new int[]{1, 2, 3, 4, 5}, 9);
            assertNotNull(indexes);
            assertEquals(2, indexes.length);
            assertArrayEquals(new int[]{3, 4}, indexes);
        }
    }

    @Test
    void test6() {
        for (Solution solution : solutions) {
            int[] indexes = solution.twoSum(new int[]{4, 2, 3, 1, 5}, 9);
            assertNotNull(indexes);
            assertEquals(2, indexes.length);
            assertArrayEquals(new int[]{0, 4}, indexes);
        }
    }

    @Test
    void test7() {
        for (Solution solution : solutions) {
            int[] indexes = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
            assertNotNull(indexes);
            assertEquals(2, indexes.length);
            assertArrayEquals(new int[]{0, 1}, indexes);
        }
    }
}
