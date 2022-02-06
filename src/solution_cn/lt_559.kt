package solution_cn

import base.Node

fun maxDepth(root: Node?): Int {
    return if (root == null) 0 else root.children.fold(0) { res, c -> maxOf(res, maxDepth(c)) } + 1
}