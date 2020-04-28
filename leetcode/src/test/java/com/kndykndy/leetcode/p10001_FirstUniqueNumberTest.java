package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p10001_FirstUniqueNumber.Solution;
import com.kndykndy.leetcode.p10001_FirstUniqueNumber.Solution1;
import com.kndykndy.leetcode.p10001_FirstUniqueNumber.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class p10001_FirstUniqueNumberTest {

    @Test
    void test1() {
        final int[] nums = {2, 3, 5};

        for (Solution solution : getSolutions(nums)) {
            assertEquals(2, solution.showFirstUnique());
            solution.add(5); // the queue is now [2,3,5,5]
            assertEquals(2, solution.showFirstUnique());
            solution.add(2); // the queue is now [2,3,5,5,2]
            assertEquals(3, solution.showFirstUnique());
            solution.add(3); // the queue is now [2,3,5,5,2,3]
            assertEquals(-1, solution.showFirstUnique());
        }
    }

    @Test
    void test2() {
        final int[] nums = {7, 7, 7, 7, 7, 7};

        for (Solution solution : getSolutions(nums)) {
            assertEquals(-1, solution.showFirstUnique());
            solution.add(7); // the queue is now [7,7,7,7,7,7,7]
            solution.add(3); // the queue is now [7,7,7,7,7,7,7,3]
            solution.add(3); // the queue is now [7,7,7,7,7,7,7,3,3]
            solution.add(7); // the queue is now [7,7,7,7,7,7,7,3,3,7]
            solution.add(17); // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
            assertEquals(17, solution.showFirstUnique());
        }
    }

    private List<Solution> getSolutions(int[] nums) {
        return Arrays.asList(new Solution1(nums), new Solution2(nums));
    }
}
