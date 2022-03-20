package cn_solution

import base.TreeNode

fun flatten(root: TreeNode?): Unit {
    var curr = root
    while (curr != null) {
        val left = curr.left
        if (left != null) {
            var temp = left
            while (temp.right != null)
                temp = temp.right
            temp.right = curr.right
            curr.right = left
            curr.left = null
        }
        curr = curr.right
    }
    return
}