package solution_cn

import base.TreeNode

fun kthSmallest(root: TreeNode?, k: Int): Int {
    var count = 0
    var result = 0
    fun traverse(node: TreeNode?) {
        node ?: return
        traverse(node.left)
        when {
            ++count > k -> return
            count == k -> result = node.`val`
        }
        traverse(node.right)
    }
    traverse(root)
    return result
}