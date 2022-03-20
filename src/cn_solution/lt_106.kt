package cn_solution

import base.TreeNode

private fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    fun buildTree(inLeft: Int, inRight: Int, postLeft: Int, postRight: Int): TreeNode? {
        if (inLeft == inRight) return null
        val inPivot = (inLeft until inRight).first { inorder[it] == postorder[postRight - 1] }
        val leftCount = inPivot - inLeft
        val postPivot = postLeft + leftCount
        return TreeNode(inorder[inPivot]).apply {
            left = buildTree(inLeft, inPivot, postLeft, postPivot)
            right = buildTree(inPivot + 1, inRight, postPivot, postRight - 1)
        }
    }
    return buildTree(0, inorder.size, 0, postorder.size)
}