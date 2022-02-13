package cn_solution

import base.TreeNode

fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    val range = low..high
    var result = 0
    fun sum(root: TreeNode?) {
        root?.run {
            if (`val` > low) sum(left)
            if (`val` < high) sum(right)
            if (`val` in range) result += `val`
        }
    }
    sum(root)
    return result
}