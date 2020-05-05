package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.ListNode;

public class p017_RemoveNthNodeFromEndOfList {

    interface Solution {

        ListNode removeNthFromEnd(ListNode head, int n);
    }

    public static class Solution1 implements Solution {

        @Override
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }

            ListNode aux = null, oldhead = head;
            int k = 0;
            while (head != null) {
                head = head.next;

                k++;
                if (k > n) {
                    if (aux == null) {
                        aux = oldhead;
                    } else {
                        aux = aux.next;
                    }
                }
            }
            if (aux == null) { //it's old root
                return oldhead.next;
            } else {
                aux.next = (aux.next != null) ? aux.next.next : null;
                return oldhead;
            }
        }
    }
}
