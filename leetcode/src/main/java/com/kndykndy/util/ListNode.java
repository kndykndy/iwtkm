package com.kndykndy.util;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode fromValues(int... values) {
        ListNode result = null;

        ListNode previousListNode = null, currentListNode;
        for (int value : values) {
            currentListNode = new ListNode(value);
            if (result == null) {
                result = currentListNode;
            }
            if (previousListNode != null) {
                previousListNode.next = currentListNode;
            }
            previousListNode = currentListNode;
        }

        return result;
    }

    public boolean equals(ListNode anotherListNode) {
        if (this == anotherListNode) {
            return true;
        }
        if (anotherListNode == null) {
            return false;
        }

        ListNode currentListNode = this;
        while (currentListNode != null || anotherListNode != null) {
            if (currentListNode == null) {
                return false;
            }
            if (anotherListNode == null) {
                return false;
            }

            if (currentListNode.val != anotherListNode.val) {
                return false;
            }

            currentListNode = currentListNode.next;
            anotherListNode = anotherListNode.next;
        }

        return true;
    }

    @Override
    public String toString() {
        ListNode node = this;
        final StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (node != null) {
            sb.append(node.val).append(node.next != null ? ',' : "");
            node = node.next;
        }
        sb.append(']');
        return sb.toString();
    }
}
