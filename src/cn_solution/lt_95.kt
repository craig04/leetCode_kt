package cn_solution

import base.TreeNode

fun generateTrees(n: Int): List<TreeNode?> {

    fun generate(l: Int, r: Int): List<TreeNode?> {
        if (l > r) return listOf(null)
        val result = ArrayList<TreeNode?>()
        for (i in l..r) {
            val left = generate(l, i - 1)
            val right = generate(i + 1, r)
            for (lc in left) {
                for (rc in right) {
                    val node = TreeNode(i)
                    node.left = lc
                    node.right = rc
                    result.add(node)
                }
            }
        }
        return result
    }
    return generate(1, n)
}