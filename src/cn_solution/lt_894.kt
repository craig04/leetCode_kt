package cn_solution

import base.TreeNode

fun allPossibleFBT(n: Int): List<TreeNode?> {
    if (n and 1 == 0)
        return emptyList()
    val trees = Array(n + 1) { ArrayList<TreeNode?>() }
    trees[1].add(TreeNode(0))
    for (i in 3..n step 2) {
        for (l in 1 until i step 2) {
            for (left in trees[l])
                for (right in trees[i - 1 - l])
                    trees[i].add(TreeNode(0, left, right))
        }
    }
    return trees[n]
}