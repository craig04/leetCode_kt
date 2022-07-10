package cn_solution

import base.TreeNode

/**
 * Morris traversal with O(1) space complexity
 */
@Suppress("FunctionName")
fun recoverTree_morrisTraverse(root: TreeNode?): Unit {
    var cur = root
    var pre = TreeNode(Int.MIN_VALUE)
    var x = pre
    var y = pre
    fun visit(cur: TreeNode) {
        if (cur.`val` < pre.`val`) {
            if (x == y) x = pre
            y = cur
        }
        pre = cur
    }
    while (cur != null) {
        var temp = cur.left
        if (temp == null) {
            visit(cur)
            cur = cur.right
        } else {
            while (temp.right != null && temp.right != cur) {
                temp = temp.right
            }
            if (temp.right == null) {
                temp.right = cur
                cur = cur.left
            } else {
                temp.right = null
                visit(cur)
                cur = cur.right
            }
        }
    }
    val num = x.`val`
    x.`val` = y.`val`
    y.`val` = num
}

/**
 * Normal dfs with O(h) space complexity
 */
@Suppress("FunctionName")
fun recoverTree_normal(root: TreeNode?): Unit {
    var pre = TreeNode(Int.MIN_VALUE)
    var x = TreeNode(0)
    var y = x
    fun dfs(cur: TreeNode?) {
        cur ?: return
        dfs(cur.left)
        if (cur.`val` < pre.`val`) {
            if (x == y) x = pre
            y = cur
        }
        pre = cur
        dfs(cur.right)
    }
    dfs(root)
    val num = x.`val`
    x.`val` = y.`val`
    y.`val` = num
}