package cn_offer

import base.TreeNode

fun pathSum(root: TreeNode?, target: Int): List<List<Int>> {
    var sum = 0
    val temp = ArrayList<Int>()
    val result = ArrayList<List<Int>>()
    fun dfs(root: TreeNode) {
        sum += root.`val`
        temp.add(root.`val`)
        if (root.left == null && root.right == null) {
            if (sum == target) result.add(ArrayList(temp))
        } else {
            root.left?.let { dfs(it) }
            root.right?.let { dfs(it) }
        }
        temp.removeAt(temp.lastIndex)
        sum -= root.`val`
    }
    root?.let { dfs(it) }
    return result
}