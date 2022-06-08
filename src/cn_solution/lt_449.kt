package cn_solution

import base.TreeNode

class Codec() {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val builder = StringBuilder()
        fun serialize(root: TreeNode?) {
            root ?: return
            builder.append(root.`val`).append(' ')
            serialize(root.left)
            serialize(root.right)
        }
        serialize(root)
        builder.setLength(maxOf(0, builder.length - 1))
        return builder.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val numbers = data.split(' ')
        if (numbers.isEmpty()) {
            return null
        }
        val preorder = IntArray(numbers.size) { numbers[it].toInt() }
        val inorder = preorder.sortedArray()
        return buildTree(preorder, inorder)
    }

    private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
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
}