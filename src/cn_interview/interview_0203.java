package cn_interview;

import base.ListNode;

class Solution_0203 {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        if (next != null) {
            node.val = next.val;
            node.next = next.next;
        }
    }
}