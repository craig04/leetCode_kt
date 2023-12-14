package cn_solution

class Graph(private val n: Int, edges: Array<IntArray>) {

    private val adj = Array(n) { IntArray(n) }

    init {
        edges.forEach { adj[it[0]][it[1]] = it[2] }
    }

    fun addEdge(edge: IntArray) {
        adj[edge[0]][edge[1]] = edge[2]
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        val dist = IntArray(n) { Int.MAX_VALUE }
        dist[node1] = 0
        val visit = BooleanArray(n)
        for (i in 0 until n) {
            var min = Int.MAX_VALUE
            var u = -1
            for (j in 0 until n)
                if (!visit[j] && dist[j] < min) {
                    min = dist[j]
                    u = j
                }
            if (u == -1 || u == node2)
                break
            visit[u] = true
            for (v in 0 until n)
                if (adj[u][v] != 0)
                    dist[v] = minOf(dist[v], dist[u] + adj[u][v])
        }
        return if (dist[node2] == Int.MAX_VALUE) -1 else dist[node2]
    }
}