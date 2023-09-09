package cn_lcr

fun sequenceReconstruction(nums: IntArray, sequences: Array<IntArray>): Boolean {
    val n = nums.size
    val adj = Array(n + 1) { HashSet<Int>() }
    val degree = IntArray(n + 1)
    for (seq in sequences)
        for (i in 1 until seq.size)
            if (adj[seq[i - 1]].add(seq[i]))
                degree[seq[i]]++
    val q = (1..n).filterTo(ArrayDeque()) { degree[it] == 0 }
    while (q.isNotEmpty()) {
        if (q.size != 1)
            return false
        val u = q.removeFirst()
        for (v in adj[u])
            if (--degree[v] == 0)
                q.add(v)
    }
    return true
}