package solution_cn

import base.TreeNode

fun minDiffInBST(root: TreeNode?): Int {
    var last = -200000
    var result = Int.MAX_VALUE
    fun dfs(node: TreeNode?) {
        node?.apply {
            dfs(left)
            result = minOf(result, `val` - last)
            last = `val`
            dfs(right)
        }
    }
    dfs(root)
    return result
}