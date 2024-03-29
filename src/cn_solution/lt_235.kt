package cn_solution

import base.TreeNode

private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (p == null || q == null || root == null) return null
    var temp: TreeNode = root
    while (true) {
        temp = if (p.`val` > temp.`val` && q.`val` > temp.`val`)
            temp.right ?: break
        else if (p.`val` < temp.`val` && q.`val` < temp.`val`)
            temp.left ?: break
        else
            break
    }
    return temp
}