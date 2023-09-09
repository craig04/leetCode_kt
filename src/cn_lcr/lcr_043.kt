package cn_lcr

import base.TreeNode

class CBTInserter(private val root: TreeNode?) {

    private val q = ArrayDeque<TreeNode>()

    init {
        q.add(root!!)
        while (q.isNotEmpty()) {
            val first = q.first()
            first.left?.also { q.add(it) }
            first.right?.also { q.add(it) }
            if (first.left == null || first.right == null)
                break
            q.removeFirst()
        }
    }

    fun insert(`val`: Int): Int {
        val parent = q.first()
        val child = TreeNode(`val`)
        if (parent.left == null) {
            parent.left = child
        } else {
            parent.right = child
            q.removeFirst()
        }
        q.addLast(child)
        return parent.`val`
    }

    fun get_root(): TreeNode? {
        return root
    }
}