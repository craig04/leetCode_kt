package cn_solution

import base.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    var temp = root
    while (temp != null || stack.isNotEmpty()) {
        temp = if (temp != null) {
            stack.push(temp)
            temp.left
        } else {
            val top = stack.pop()
            result.add(top.`val`)
            top.right
        }
    }
    return result
}