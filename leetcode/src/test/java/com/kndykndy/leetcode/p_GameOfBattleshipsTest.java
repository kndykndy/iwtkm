package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p_GameOfBattleships.Solution;
import com.kndykndy.leetcode.p_GameOfBattleships.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p_GameOfBattleshipsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals("1,1", solution.solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"));
            assertEquals("1,0", solution.solution(12, "1A 2A,12A 12A", "12A"));
            assertEquals("0,1", solution.solution(3, "1A 1B,2C 2C", "1B"));
        }
    }
}
