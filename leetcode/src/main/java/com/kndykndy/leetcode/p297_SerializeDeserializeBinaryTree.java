package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p297_SerializeDeserializeBinaryTree {

    interface Solution {

        // Encodes a tree to a single string.
        String serialize(TreeNode root);

        // Decodes your encoded data to tree.
        TreeNode deserialize(String data);
    }

    public static class Solution1 implements Solution {

        @Override
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            if (root.left == null && root.right == null) {
                return "[" + root.val + "]";
            }

            final List<TreeNode> currentLevel = new LinkedList<>();
            final List<TreeNode> nextLevel = new ArrayList<>();
            final List<TreeNode> total = new LinkedList<>();

            currentLevel.add(root);

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

        @Override
        public TreeNode deserialize(String data) {
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

    public static class Solution2 implements Solution {

        @Override
        public String serialize(TreeNode root) {
            return null; // todo
        }

        @Override
        public TreeNode deserialize(String data) {
            return null; // todo
        }
    }
}
