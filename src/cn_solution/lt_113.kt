package cn_solution

import base.TreeNode

private fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    var sum = 0
    val list = ArrayList<Int>()
    val result = ArrayList<List<Int>>()
    fun dfs(root: TreeNode) {
        sum += root.`val`
        list.add(root.`val`)
        if (root.left == null && root.right == null) {
            if (sum == targetSum) result.add(ArrayList(list))
        } else {
            root.left?.let { dfs(it) }
            root.right?.let { dfs(it) }
        }
        list.removeAt(list.lastIndex)
        sum -= root.`val`
    }
    root?.let { dfs(it) }
    return result
}