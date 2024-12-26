package cn_solution

import base.ListNode
import base.TreeNode

fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
    fun dfs(node: ListNode?, root: TreeNode?): Boolean {
        node ?: return true
        root ?: return false
        return node.`val` == root.`val` && (dfs(node.next, root.left) || dfs(node.next, root.right)) ||
                node == head && (dfs(node, root.left) || dfs(node, root.right))
    }
    return dfs(head, root)
}