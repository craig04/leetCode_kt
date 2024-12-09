package cn_solution

import base.TreeNode

fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
    val start = ArrayList<Pair<TreeNode, Char>>()
    val dest = ArrayList<Pair<TreeNode, Char>>()
    fun findPath(node: TreeNode?, path: ArrayList<Pair<TreeNode, Char>>) {
        node ?: return
        when (node.`val`) {
            startValue -> start.addAll(path)
            destValue -> dest.addAll(path)
        }
        node.left?.let {
            path.add(Pair(it, 'L'))
            findPath(it, path)
            path.removeLast()
        }
        node.right?.let {
            path.add(Pair(it, 'R'))
            findPath(it, path)
            path.removeLast()
        }
    }
    findPath(root, ArrayList())
    var i = 0
    val size = minOf(start.size, dest.size)
    while (i != size && start[i].first == dest[i].first)
        i++
    val ans = StringBuilder()
    repeat(start.size - i) { ans.append('U') }
    while (i < dest.size)
        ans.append(dest[i++].second)
    return ans.toString()
}