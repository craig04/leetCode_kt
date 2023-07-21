package cn_offer

import base.TreeNode

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    fun build(preLeft: Int, preRight: Int, inLeft: Int, inRight: Int): TreeNode? {
        if (preLeft == preRight) {
            return null
        }
        val inPivot = (inLeft until inRight).first { inorder[it] == preorder[preLeft] }
        val leftSize = inPivot - inLeft
        val rightSize = inRight - inPivot - 1
        return TreeNode(preorder[preLeft]).apply {
            left = build(preLeft + 1, preLeft + 1 + leftSize, inLeft, inPivot)
            right = build(preRight - rightSize, preRight, inPivot + 1, inRight)
        }
    }
    return build(0, preorder.size, 0, inorder.size)
}