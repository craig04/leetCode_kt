package cn_solution

fun largestValsFromLabels(values: IntArray, labels: IntArray, numWanted: Int, useLimit: Int): Int {
    val indices = values.indices.sortedByDescending { values[it] }
    val map = HashMap<Int, Int>()
    var result = 0
    var chosen = 0
    for (i in indices) {
        val label = labels[i]
        val cnt = map[label] ?: 0
        if (cnt == useLimit) {
            continue
        }
        map[label] = cnt + 1
        result += values[i]
        if (++chosen == numWanted) {
            break
        }
    }
    return result
}