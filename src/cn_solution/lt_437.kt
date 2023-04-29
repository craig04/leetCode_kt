package cn_solution

import base.TreeNode

private fun pathSum(root: TreeNode?, targetSum: Int): Int {
    val map = hashMapOf(0L to 1)
    fun search(node: TreeNode?, preSum: Long): Int {
        node ?: return 0
        val temp = preSum + node.`val`
        var result = map[temp - targetSum] ?: 0
        map[temp] = (map[temp] ?: 0) + 1
        result += search(node.left, temp)
        result += search(node.right, temp)
        map[temp] = (map[temp] ?: 1) - 1
        return result
    }
    return search(root, 0)
}