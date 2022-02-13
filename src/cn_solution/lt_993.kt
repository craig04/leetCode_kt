package cn_solution

import base.TreeNode

fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    var px = root
    var py = root
    var dx = -1
    var dy = -2
    fun init(parent: TreeNode?, cur: TreeNode?, depth: Int) {
        cur ?: return
        if (cur.`val` == x) {
            px = parent
            dx = depth
        } else if (cur.`val` == y) {
            py = parent
            dy = depth
        }
        init(cur, cur.left, depth + 1)
        init(cur, cur.right, depth + 1)
    }
    init(null, root, 0)
    return dx == dy && px != py
}