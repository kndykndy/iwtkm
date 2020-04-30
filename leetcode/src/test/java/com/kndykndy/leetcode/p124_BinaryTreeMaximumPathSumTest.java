package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p124_BinaryTreeMaximumPathSum.OptimalSolution;
import com.kndykndy.leetcode.p124_BinaryTreeMaximumPathSum.Solution;
import com.kndykndy.leetcode.p124_BinaryTreeMaximumPathSum.Solution1;
import com.kndykndy.leetcode.util.TreeNode;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p124_BinaryTreeMaximumPathSumTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = List.of(new Solution1(), new OptimalSolution());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(1, solution.maxPathSum(TreeNode.deserialize("[-1,0,1]")));
            assertEquals(-3, solution.maxPathSum(TreeNode.deserialize("[-3]")));
            assertEquals(3, solution.maxPathSum(TreeNode.deserialize("[1,2]")));
            assertEquals(1, solution.maxPathSum(TreeNode.deserialize("[1,-2]")));
            assertEquals(2, solution.maxPathSum(TreeNode.deserialize("[-1,2]")));
            assertEquals(-1, solution.maxPathSum(TreeNode.deserialize("[-1,-2]")));
            assertEquals(6, solution.maxPathSum(TreeNode.deserialize("[1,2,3]")));

            assertEquals(
                42,
                solution.maxPathSum(TreeNode.deserialize("[-10,9,20,null,null,15,7]")));

            assertEquals(
                16,
                solution.maxPathSum(TreeNode.deserialize(
                    "[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]")));

            assertEquals(
                48,
                solution.maxPathSum(TreeNode.deserialize(
                    "[5,4,8,11,null,13,4,7,2,null,null,null,1]")));
        }
    }
}
