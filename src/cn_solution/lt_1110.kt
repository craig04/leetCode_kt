package cn_solution

import base.TreeNode

fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
    val result = ArrayList<TreeNode?>()
    val set = to_delete.toHashSet()
    fun TreeNode?.delete(isRoot: Boolean): TreeNode? {
        this ?: return null
        val contain = set.remove(`val`)
        left = left.delete(contain)
        right = right.delete(contain)
        if (contain)
            return null
        result.add(this)
        return this
    }
    root.delete(true)
    return result
}