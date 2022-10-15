package cn_solution

import base.TreeNode

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    val trees = HashMap<String, Int>()
    var index = 0
    fun hash(node: TreeNode?): Int {
        node ?: return 0
        val left = hash(node.left)
        val right = hash(node.right)
        val str = "${left}_${node.`val`}_$right"
        return trees.getOrPut(str) { ++index }
    }
    hash(root)
    fun judge(node: TreeNode?): Int {
        node ?: return 0
        val left = hash(node.left)
        if (left < 0) return -1
        val right = hash(node.right)
        if (right < 0) return -1
        val str = "${left}_${node.`val`}_$right"
        return trees[str] ?: -1
    }
    return judge(subRoot) >= 0
}