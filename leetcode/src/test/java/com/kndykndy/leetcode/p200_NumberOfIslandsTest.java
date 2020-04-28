package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p200_NumberOfIslands.Solution;
import com.kndykndy.leetcode.p200_NumberOfIslands.Solution1;
import com.kndykndy.leetcode.util.Utils;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p200_NumberOfIslandsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(
                3,
                solution.numIslands(
                    Utils.strTo2DCharArray("[[1,1,0,0,0],[1,1,0,0,0],[0,0,1,0,0],[0,0,0,1,1]]")));
            assertEquals(
                1,
                solution.numIslands(Utils.strTo2DCharArray("[[1,1,1],[0,1,0],[1,1,1]]")));
            assertEquals(
                1,
                solution.numIslands(
                    Utils.strTo2DCharArray("[[1,0,1,1,1],[1,0,1,0,1],[1,1,1,0,1]]")));
        }
    }
}
