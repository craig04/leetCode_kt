package solution_cn

import base.ListNode

fun removeDuplicateNodes(head: ListNode?): ListNode? {
    val set = HashSet<Int>()
    val dummy = ListNode(0)
    dummy.next = head
    var temp = dummy
    while (true) {
        temp.next?.let {
            if (set.add(it.`val`)) {
                temp = it
            } else {
                temp.next = it.next
            }
        } ?: return dummy.next
    }
}