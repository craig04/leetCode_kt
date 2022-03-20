package cn_solution

import base.TreeNode

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    return if (p == null) q == null else q != null
            && q.`val` == p.`val`
            && isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right)
}