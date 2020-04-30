package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p_PerformStringShifts.Solution;
import com.kndykndy.leetcode.p_PerformStringShifts.Solution1;
import com.kndykndy.leetcode.util.Utils;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p_PerformStringShiftsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(
                "efgabcd",
                solution.stringShift(
                    "abcdefg",
                    Utils.strTo2DIntArray("[[1,1],[1,1],[0,2],[1,3]]")));

            assertEquals(
                "defgabc",
                solution.stringShift("abcdefg", Utils.strTo2DIntArray("[[0,3]]")));

            assertEquals(
                "qpifxqgwki",
                solution.stringShift(
                    "xqgwkiqpif",
                    Utils.strTo2DIntArray(
                        "[[1,4],[0,7],[0,8],[0,7],[0,6],[1,3],[0,1],[1,7],[0,5],[0,6]]")));
        }
    }
}
