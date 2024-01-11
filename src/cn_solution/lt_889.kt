package cn_solution

import base.TreeNode

fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
    val pos = postorder.indices.associateByTo(HashMap()) { postorder[it] }
    fun construct(l: Int, r: Int, i: Int, j: Int): TreeNode {
        val node = TreeNode(preorder[l])
        if (l == r)
            return node
        val pivot = pos[preorder[l + 1]]!!
        val len = pivot - i + 1
        node.left = construct(l + 1, l + len, i, pivot)
        if (pivot != j - 1)
            node.right = construct(l + len + 1, r, pivot + 1, j - 1)
        return node
    }
    return construct(0, preorder.lastIndex, 0, postorder.lastIndex)
}