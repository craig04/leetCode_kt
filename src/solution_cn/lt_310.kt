package solution_cn

/**
 * TODO: TO BE UPDATE
 */
fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    val adj = Array(n) { ArrayList<Int>() }
    for (e in edges) {
        adj[e[0]].add(e[1])
        adj[e[1]].add(e[0])
    }
    fun dfs(src: Int, prev: Int, distance: Int, func: (Int, Int) -> Unit) {
        adj[src].forEach {
            if (it != prev) {
                dfs(it, src, distance + 1, func)
            }
        }
        func(src, distance)
    }

    var longest = 0
    var node = 0
    val findLongest: (Int, Int) -> Unit = { src, dis ->
        if (dis > longest) {
            longest = dis
            node = src
        }
    }
    dfs(0, 0, 0, findLongest)
    dfs(node, node, 0, findLongest)
    val result = ArrayList<Int>()
    fun search(src: Int, prev: Int, distance: Int): Boolean {
        val a = adj[src]
        val isPath = if (a.isEmpty() || (a.size == 1 && a.first() == prev))
            distance == longest
        else a.fold(false) { acc, i ->
            if (i == prev) acc else acc or search(i, src, distance + 1)
        }
        if (isPath && (distance == longest / 2 || distance == (longest + 1) / 2)) {
            result.add(src)
        }
        return isPath
    }
    search(node, node, 0)
    return result
}