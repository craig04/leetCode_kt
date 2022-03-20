package cn_solution

import base.TreeNode
import java.util.*

fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    val result = LinkedList<List<Int>>()
    val list = ArrayList<TreeNode>()
    fun ArrayList<TreeNode>.safeAdd(root: TreeNode?) = root?.let { add(it) }
    list.safeAdd(root)
    while (list.isNotEmpty()) {
        val next = ArrayList<TreeNode>()
        result.addFirst(list.map {
            next.safeAdd(it.left)
            next.safeAdd(it.right)
            it.`val`
        })
        list.clear()
        list.addAll(next)
    }
    return result
}