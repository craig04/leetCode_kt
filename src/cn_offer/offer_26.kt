package cn_offer

import base.TreeNode

fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
    fun equal(a: TreeNode?, b: TreeNode?): Boolean {
        return when {
            b == null -> true
            a == null || a.`val` != b.`val` -> false
            else -> equal(a.left, b.left) && equal(a.right, b.right)
        }
    }
    return A != null && B != null &&
            (equal(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B))
}