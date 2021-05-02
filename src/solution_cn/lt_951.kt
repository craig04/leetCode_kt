package solution_cn

import base.TreeNode

fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
    return if (root1 == null) root2 == null else root2 != null
            && root1.`val` == root2.`val`
            && (flipEquiv(root1.left, root2.left)
            && flipEquiv(root1.right, root2.right)
            || flipEquiv(root1.left, root2.right)
            && flipEquiv(root1.right, root2.left))
}