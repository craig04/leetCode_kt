package solution_cn

import base.ListNode
import base.TreeNode

fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
    fun dfs(head: ListNode?, root: TreeNode?): Boolean {
        head ?: return true
        return root != null
                && head.`val` == root.`val`
                && (dfs(head.next, root.left)
                || dfs(head.next, root.right))
    }
    return root != null
            && (dfs(head, root)
            || isSubPath(head, root.left)
            || isSubPath(head, root.right))
}