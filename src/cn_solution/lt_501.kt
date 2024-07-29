package cn_solution

import base.TreeNode

fun findMode(root: TreeNode?): IntArray {
    val ans = ArrayList<Int>()
    var maxCount = 0
    var number = Int.MIN_VALUE
    var count = 0
    fun check() {
        if (count > maxCount) {
            maxCount = count
            ans.clear()
        }
        if (count == maxCount)
            ans.add(number)
    }

    fun TreeNode.dfs() {
        left?.dfs()
        if (number == `val`)
            count++
        else {
            check()
            number = `val`
            count = 1
        }
        right?.dfs()
    }
    root?.dfs()
    check()
    return ans.toIntArray()
}