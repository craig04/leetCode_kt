package cn_lcr

fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val list = ArrayList<Int>()
    fun dfs(i: Int) {
        list.add(i)
        if (i == graph.size - 1) {
            result.add(ArrayList(list))
        } else {
            for (j in graph[i]) dfs(j)
        }
        list.remove(i)
    }
    dfs(0)
    return result
}