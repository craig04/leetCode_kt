package cn_lcr

class Solution_LCR_029 {

    class Node(var `val`: Int) {
        var next: Node? = null
    }

    fun insert(head: Node?, insertVal: Int): Node? {
        if (head == null)
            return Node(insertVal).apply { next = this }
        var node: Node = head
        var next = head.next ?: return null
        do {
            if (insertVal in node.`val`..next.`val` ||
                (node.`val` > next.`val` && insertVal !in next.`val` + 1 until node.`val`)
            )
                break
            node = next
            next = next.next ?: break
        } while (node != head)
        node.next = Node(insertVal).also { it.next = node.next }
        return head
    }
}