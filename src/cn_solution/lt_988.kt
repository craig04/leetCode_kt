package cn_solution

import base.TreeNode

fun smallestFromLeaf(root: TreeNode?): String {
    val ans = arrayListOf(26)
    val str = ArrayList<Int>()
    fun TreeNode.dfs() {
        str.add(`val`)
        if (left == null && right == null) {
            fun update(): Boolean {
                var i = ans.lastIndex
                var j = str.lastIndex
                while (i >= 0 && j >= 0) {
                    if (ans[i] != str[j])
                        return ans[i] > str[j]
                    i--
                    j--
                }
                return i >= 0
            }
            if (update()) {
                ans.clear()
                ans.addAll(str)
            }
        }
        left?.dfs()
        right?.dfs()
        str.removeLast()
    }
    root?.dfs()
    val s = StringBuilder()
    for (c in ans.asReversed())
        s.append('a' + c)
    return s.toString()
}