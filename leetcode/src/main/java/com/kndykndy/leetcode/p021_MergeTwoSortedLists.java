package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.ListNode;

public class p021_MergeTwoSortedLists {

    interface Solution {

        ListNode mergeTwoLists(ListNode l1, ListNode l2);
    }

    public static class Solution1 implements Solution {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode originalRoot = null, root = null, nNode;
            int v;

            while (l1 != null || l2 != null) {

                v = Math.min(
                    (l1 != null) ? l1.val : Integer.MAX_VALUE,
                    (l2 != null) ? l2.val : Integer.MAX_VALUE
                );

                nNode = new ListNode(v);

                if (root != null) {
                    root.next = nNode;
                    root = root.next;
                } else {
                    root = nNode;
                    originalRoot = nNode;
                }

                if (l1 != null && l1.val == v) {
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                }
            }

            return originalRoot;
        }
    }
}
