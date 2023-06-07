package cn_solution

fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
    val stat = IntArray(2002)
    val cnt = IntArray(26)
    fun String.minFreq(): Int {
        cnt.fill(0)
        forEach { cnt[it - 'a']++ }
        return cnt.first { it != 0 }
    }
    words.forEach { stat[it.minFreq()]++ }
    for (i in stat.lastIndex downTo 1) {
        stat[i - 1] += stat[i]
    }
    return IntArray(queries.size) { stat[queries[it].minFreq() + 1] }
}