package cn_lcr

import base.TreeNode

fun increasingBST(root: TreeNode?): TreeNode? {
    val dummy = TreeNode(0)
    var temp = dummy
    fun reorder(root: TreeNode?) {
        root ?: return
        reorder(root.left)
        temp.right = root
        root.left = null
        temp = root
        reorder(root.right)
    }
    reorder(root)
    return dummy.right
}