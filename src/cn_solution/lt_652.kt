package cn_solution

import base.TreeNode

fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
    class Helper(val node: TreeNode, val index: Int, var count: Int)

    val map = HashMap<String, Helper>()
    var index = 0
    fun TreeNode?.dfs(): Int {
        this ?: return 0
        val hash = "${left.dfs()},$`val`,${right.dfs()}"
        val helper = map.getOrPut(hash) { Helper(this, ++index, 0) }
        helper.count++
        return helper.index
    }
    root.dfs()
    val result = ArrayList<TreeNode?>()
    for (h in map.values)
        if (h.count > 1)
            result.add(h.node)
    return result
}