package solution

import base.TreeNode

fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    return if (nums.isEmpty()) null else nums.construct(0, nums.size - 1)
}

private fun IntArray.construct(from: Int, to: Int): TreeNode {
    val pivot = (from..to).maxBy { this[it] }!!
    return TreeNode(this[pivot]).also {
        if (pivot != from) {
            it.left = construct(from, pivot - 1)
        }
        if (pivot != to) {
            it.right = construct(pivot + 1, to)
        }
    }
}