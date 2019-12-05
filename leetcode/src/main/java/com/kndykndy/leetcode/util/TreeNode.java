package com.kndykndy.leetcode.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public boolean isEqual(TreeNode tree) {
        return isEqualImpl(this, tree);
    }

    private boolean isEqualImpl(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && isEqualImpl(p.left, q.left) && isEqualImpl(p.right, q.right);
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            '}';
    }

    public static TreeNode from(int self, Integer left, Integer right) {
        final TreeNode root = new TreeNode(self);
        root.left = left != null ? new TreeNode(left) : null;
        root.right = right != null ? new TreeNode(right) : null;
        return root;
    }

    public static void add(TreeNode node, int left, int right) {
        node.left = new TreeNode(left);
        node.right = new TreeNode(right);
    }

    public static String asString(TreeNode treeNode) {
        return treeNode != null ? treeNode.toString() : "null";
    }

    public static String serialize(TreeNode tree) {
        if (tree == null) {
            return "[]";
        }
        if (tree.left == null && tree.right == null) {
            return "[" + tree.val + "]";
        }

        final List<TreeNode> currentLevel = new LinkedList<>();
        final List<TreeNode> nextLevel = new ArrayList<>();
        final List<TreeNode> total = new LinkedList<>();

        currentLevel.add(tree);

        while (true) {
            for (TreeNode node : currentLevel) {
                total.add(node);

                if (node != null) {
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
            }

            if (nextLevel.isEmpty()) {
                break;
            }

            currentLevel.clear();
            currentLevel.addAll(nextLevel);
            nextLevel.clear();
        }

        final StringBuilder sb = new StringBuilder();

        int realSize = total.size();
        while (total.get(realSize - 1) == null) {
            realSize--;
        }
        for (TreeNode node : total) {
            sb.append(node != null ? node.val : "null").append(',');
            if (--realSize == 0) {
                break;
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        return "[" + sb.toString() + "]";
    }

    public static TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }

        final String[] values = data.substring(1, data.length() - 1).split(",");
        final List<TreeNode> prevNodes = new LinkedList<>();
        final List<TreeNode> currentNodes = new LinkedList<>();
        final TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        String tempString;
        int k = 1;

        prevNodes.add(root);

        while (k < values.length) {
            for (TreeNode prevNode : prevNodes) {
                if (prevNode == null) {
                    continue;
                }

                if (k >= values.length) {
                    break;
                }
                tempString = values[k++];
                prevNode.left = !"null".equalsIgnoreCase(tempString)
                    ? new TreeNode(Integer.parseInt(tempString)) : null;
                currentNodes.add(prevNode.left);

                if (k >= values.length) {
                    break;
                }
                tempString = values[k++];
                prevNode.right = !"null".equalsIgnoreCase(tempString)
                    ? new TreeNode(Integer.parseInt(tempString)) : null;
                currentNodes.add(prevNode.right);
            }

            if (currentNodes.isEmpty()) {
                break;
            }

            prevNodes.clear();
            prevNodes.addAll(currentNodes);
            currentNodes.clear();
        }

        return root;
    }
}
