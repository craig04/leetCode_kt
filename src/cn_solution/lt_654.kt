package cn_solution

import base.TreeNode

fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    val nodes = Array(nums.size) { TreeNode(nums[it]) }
    val stack = Array<TreeNode?>(nums.size) { null }
    var top = -1
    nums.forEachIndexed { i, n ->
        val node = nodes[i]
        while (top >= 0 && n > stack[top]!!.`val`) {
            node.left = stack[top--]
        }
        if (top != -1)
            stack[top]?.right = node
        stack[++top] = node
    }
    return stack.first()
}