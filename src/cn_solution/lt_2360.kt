package cn_solution

fun longestCycle(edges: IntArray): Int {
    val n = edges.size
    val time = IntArray(n)
    var cur = 1
    var result = -1
    for (i in 0 until n) {
        if (time[i] != 0)
            continue
        var j = i
        do {
            time[j] = cur++
            j = edges[j]
        } while (j != -1 && time[j] == 0)
        if (j != -1 && time[j] >= time[i])
            result = maxOf(result, cur - time[j])
    }
    return result
}