package cn_lcr

import base.TreeNode
import java.util.*

class BSTIterator(root: TreeNode?) {

    private val stack = Stack<TreeNode>().apply { leftmost(root, this) }

    private fun leftmost(root: TreeNode?, stack: Stack<TreeNode>) {
        var temp = root
        while (temp != null) {
            stack.push(temp)
            temp = temp.left
        }
    }

    fun next(): Int {
        val node = stack.pop()
        leftmost(node.right, stack)
        return node.`val`
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }
}