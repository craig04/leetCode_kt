package solution_cn

import base.TreeNode

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    fun TreeNode.dfs(list: ArrayList<Int>) {
        if (left == null && right == null) {
            list.add(`val`)
        } else {
            left?.run { dfs(list) }
            right?.run { dfs(list) }
        }
    }

    val list1 = ArrayList<Int>().apply { root1?.dfs(this) }
    val list2 = ArrayList<Int>().apply { root2?.dfs(this) }
    return list1 == list2
}