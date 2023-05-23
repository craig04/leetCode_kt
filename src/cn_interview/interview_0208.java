package cn_interview;

import base.ListNode;

class Solution_0208 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = fast == null || fast.next == null ? null : fast.next.next;
            if (fast == null)
                return null;
            slow = slow.next;
        } while (fast != slow);
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
