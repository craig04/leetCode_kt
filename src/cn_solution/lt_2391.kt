package cn_solution

fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
    var result = garbage[0].length
    val dist = IntArray(26)
    for (i in 1 until garbage.size) {
        dist[6] += travel[i - 1]
        dist[12] += travel[i - 1]
        dist[15] += travel[i - 1]
        result += garbage[i].length
        for (c in garbage[i]) {
            result += dist[c - 'A']
            dist[c - 'A'] = 0
        }
    }
    return result
}