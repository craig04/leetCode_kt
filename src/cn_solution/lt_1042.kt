package cn_solution

fun gardenNoAdj(n: Int, paths: Array<IntArray>): IntArray {
    val color = IntArray(n)
    val adj = Array(n) { ArrayList<Int>() }
    paths.forEach { (i, j) ->
        adj[i - 1].add(j - 1)
        adj[j - 1].add(i - 1)
    }
    for (i in 0 until n) {
        color[i] = Integer.lowestOneBit(adj[i].fold(15) { temp, j -> temp and color[j].inv() })
    }
    return IntArray(n) { 1 + (0..3).first { t -> color[it] == 1 shl t } }
}