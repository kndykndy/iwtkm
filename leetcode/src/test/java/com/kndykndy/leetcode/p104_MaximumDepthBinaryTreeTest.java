package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p104_MaximumDepthBinaryTree.Solution;
import com.kndykndy.leetcode.p104_MaximumDepthBinaryTree.Solution1;
import com.kndykndy.leetcode.p104_MaximumDepthBinaryTree.Solution2;
import com.kndykndy.leetcode.p104_MaximumDepthBinaryTree.Solution3;
import com.kndykndy.leetcode.p104_MaximumDepthBinaryTree.Solution4;
import com.kndykndy.leetcode.util.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p104_MaximumDepthBinaryTreeTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(
            new Solution1(), new Solution2(), new Solution3(), new Solution4());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            final TreeNode root = TreeNode.from(3, 9, 20);
            TreeNode.add(root.right, 15, 7);

            assertEquals(3, solution.maxDepth(root));
        }
    }
}
