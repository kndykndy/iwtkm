package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.kndykndy.leetcode.p283_MoveZeroes.Solution;
import com.kndykndy.leetcode.p283_MoveZeroes.Solution1;
import com.kndykndy.leetcode.p283_MoveZeroes.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p283_MoveZeroesTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            int[] nums;

            nums = new int[]{0};
            solution.moveZeroes(nums);
            assertArrayEquals(new int[]{0}, nums);

            nums = new int[]{1};
            solution.moveZeroes(nums);
            assertArrayEquals(new int[]{1}, nums);

            nums = new int[]{0, 1};
            solution.moveZeroes(nums);
            assertArrayEquals(new int[]{1, 0}, nums);

            nums = new int[]{0, 1, 0, 3, 12};
            solution.moveZeroes(nums);
            assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);

            nums = new int[]{0, 0, 1, 1, 0, 3, 12};
            solution.moveZeroes(nums);
            assertArrayEquals(new int[]{1, 1, 3, 12, 0, 0, 0}, nums);

            nums = new int[]{0, 0, 1, 1, 0, 3, 12, 0};
            solution.moveZeroes(nums);
            assertArrayEquals(new int[]{1, 1, 3, 12, 0, 0, 0, 0}, nums);

            nums = new int[]{1, 0, 1, 1, 0, 3, 12, 0};
            solution.moveZeroes(nums);
            assertArrayEquals(new int[]{1, 1, 1, 3, 12, 0, 0, 0}, nums);
        }
    }
}
