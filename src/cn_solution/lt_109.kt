package cn_solution

import base.ListNode
import base.TreeNode

fun sortedListToBST(head: ListNode?): TreeNode? {
    var temp = head
    var length = 0
    while (temp != null) {
        length++
        temp = temp.next
    }
    temp = head
    fun buildTree(length: Int): TreeNode? {
        if (length == 0) return null
        val bit = Integer.highestOneBit(length)
        val count = minOf(bit - 1, bit.inv().and(length) + bit.shr(1))
        return TreeNode(0).apply {
            left = buildTree(count)
            `val` = temp!!.`val`
            temp = temp?.next
            right = buildTree(length - count - 1)
        }
    }
    return buildTree(length)
}