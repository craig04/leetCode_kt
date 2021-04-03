package solution_cn

import base.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class Node(val node: TreeNode, var visit: Boolean)

fun postorderTraversal(root: TreeNode?): List<Int> {
    val result = ArrayList<Int>()
    val stack = Stack<Node>()
    var temp = root
    while (temp != null || stack.isNotEmpty()) {
        if (temp != null) {
            stack.add(Node(temp, false))
            temp = temp.left
        } else if (stack.peek().visit) {
            result.add(stack.pop().node.`val`)
        } else {
            val node = stack.peek()
            node.visit = true
            temp = node.node.right
        }
    }
    return result
}