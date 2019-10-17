package base

fun printList(head: ListNode?) {
    var node = head
    while (node != null) {
        print("${node.`val`}")
        node = node.next?.apply { print(" -> ") }
    }
}

fun createList(vararg `val`: Int): ListNode? {
    val head = ListNode(0)
    var node = head
    `val`.forEach {
        val next = ListNode(it)
        node.next = next
        node = next
    }
    return head.next
}