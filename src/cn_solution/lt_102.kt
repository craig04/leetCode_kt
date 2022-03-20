package cn_solution

import base.TreeNode

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val list = ArrayList<TreeNode>()
    fun ArrayList<TreeNode>.safeAdd(root: TreeNode?) = root?.let { add(it) }
    list.safeAdd(root)
    while (list.isNotEmpty()) {
        val next = ArrayList<TreeNode>()
        result.add(list.map {
            next.safeAdd(it.left)
            next.safeAdd(it.right)
            it.`val`
        })
        list.clear()
        list.addAll(next)
    }
    return result
}