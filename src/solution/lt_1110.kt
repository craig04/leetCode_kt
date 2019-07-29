package solution

import base.TreeNode

fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {

    val set = to_delete.toHashSet()
    return ArrayList<TreeNode?>().apply {
        fun delNodes(root: TreeNode?, del_father: Boolean): TreeNode? = root?.let {
            val del = set.contains(it.`val`)
            root.left = delNodes(it.left, del)
            root.right = delNodes(it.right, del)
            if (del) {
                null
            } else {
                if (del_father) add(root)
                root
            }
        }
        delNodes(root, true)
    }
}