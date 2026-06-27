package cn_solution

fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
    val map = HashMap<Int, ArrayList<Int>>()
    for ((x, y) in adjacentPairs) {
        map.getOrPut(x) { ArrayList() }.add(y)
        map.getOrPut(y) { ArrayList() }.add(x)
    }
    val n = adjacentPairs.size + 1
    val ans = IntArray(n)
    ans[0] = map.entries.first { it.value.size == 1 }.key
    ans[1] = map[ans[0]]!![0]
    for (i in 2 until n) {
        val adj = map[ans[i - 1]]!!
        ans[i] = if (adj[0] == ans[i - 2]) adj[1] else adj[0]
    }
    return ans
}