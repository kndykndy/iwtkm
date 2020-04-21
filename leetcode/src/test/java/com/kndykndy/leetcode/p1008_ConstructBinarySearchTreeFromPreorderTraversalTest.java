package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p1008_ConstructBinarySearchTreeFromPreorderTraversal.BruteForceSolution;
import com.kndykndy.leetcode.p1008_ConstructBinarySearchTreeFromPreorderTraversal.Solution;
import com.kndykndy.leetcode.p1008_ConstructBinarySearchTreeFromPreorderTraversal.Solution1;
import com.kndykndy.leetcode.util.TreeNode;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p1008_ConstructBinarySearchTreeFromPreorderTraversalTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = List.of(new BruteForceSolution(), new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(
                "[8,5,10,1,7,null,12]",
                TreeNode.serialize(solution.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12})));
        }
    }
}
