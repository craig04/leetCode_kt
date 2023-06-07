package cn_interview

import base.TreeNode

fun checkSubTree(t1: TreeNode?, t2: TreeNode?): Boolean {
    var result = false
    fun TreeNode?.hash(func: (Int) -> Unit): Int {
        return when (this) {
            null -> Int.MAX_VALUE
            else -> left.hash(func) + `val` * 31 + right.hash(func) * 961
        }.apply(func)
    }

    val target = t2.hash {}
    t1.hash { result = result or (it == target) }
    return result
}