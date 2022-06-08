package cn_solution

import base.TreeNode

fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    root ?: return null
    if (root.`val` > key) {
        root.left = deleteNode(root.left, key)
    } else if (root.`val` < key) {
        root.right = deleteNode(root.right, key)
    } else {
        val left = root.left
        val right = root.right
        return when {
            left == null -> right
            right == null -> left
            else -> {
                var succ = right
                do {
                    val temp = succ.right ?: break
                    succ = temp
                } while (true)
                root.left = deleteNode(root.right, succ.`val`)
                succ.left = root.left
                succ.right = root.right
                succ
            }
        }
    }
    return root
}