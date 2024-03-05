package cn_solution

import base.TreeNode

class FindElements(private val root: TreeNode?) {

    init {
        fun TreeNode?.init(x: Int) {
            this ?: return
            `val` = x
            left.init(x * 2 + 1)
            right.init(x * 2 + 2)
        }
        root.init(0)
    }

    fun find(target: Int): Boolean {
        val t = target + 1
        var bit = t.takeHighestOneBit() shr 1
        var node = root ?: return false
        while (bit != 0) {
            node = (if (bit and t == 0) node.left else node.right) ?: break
            bit = bit shr 1
        }
        return bit == 0
    }
}