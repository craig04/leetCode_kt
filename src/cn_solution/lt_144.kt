package cn_solution

import base.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun preorderTraversal(root: TreeNode?): List<Int> {
    val result = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    var temp = root
    while (temp != null || stack.isNotEmpty()) {
        temp = if (temp != null) {
            result.add(temp.`val`)
            stack.push(temp)
            temp.left
        } else {
            stack.pop().right
        }
    }
    return result
}