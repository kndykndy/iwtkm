package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.ListNode;
import java.util.PriorityQueue;

public class p023_MergeKSortedLists {

    interface Solution {

        ListNode mergeKLists(ListNode[] lists);
    }

    public static class Solution1 implements Solution {

        @Override
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            final PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (ListNode list : lists) {
                while (list != null) {
                    pq.add(list.val);
                    list = list.next;
                }
            }

            ListNode root = null, cur = null;
            while (!pq.isEmpty()) {
                ListNode n = new ListNode(pq.poll());
                if (root != null) {
                    cur.next = n;
                    cur = cur.next;
                } else {
                    root = n;
                    cur = n;
                }
            }
            
            return root;
        }
    }
}
