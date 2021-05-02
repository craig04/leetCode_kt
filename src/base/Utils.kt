package base

import java.util.*

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

fun createTree(vararg `val`: Int?): TreeNode? {
    if (`val`.isEmpty()) {
        return null
    }
    val dummy = TreeNode(0)
    val queue = LinkedList<Pair<TreeNode, Boolean>>()
    queue.add(Pair(dummy, false))
    for (v in `val`) {
        val temp = queue.poll()
        val node = v?.let { TreeNode(it) }?.apply {
            queue.add(Pair(this, true))
            queue.add(Pair(this, false))
        }
        if (temp.second) {
            temp.first.left = node
        } else {
            temp.first.right = node
        }
    }
    return dummy.right
}