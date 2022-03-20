package cn_solution

import base.TreeNode

fun tree2str(root: TreeNode?): String {
    val sb = StringBuilder()
    fun build(root: TreeNode?) {
        sb.append('(')
        if (root != null) {
            sb.append(root.`val`)
            if (root.right != null) {
                build(root.left)
                build(root.right)
            } else if (root.left != null) {
                build(root.left)
            }
        }
        sb.append(')')
    }
    build(root)
    return sb.substring(1, sb.lastIndex).toString()
}