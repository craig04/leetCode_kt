package cn_solution

fun appealSum(s: String): Long {
    val pos = IntArray(26) { -1 }
    var sum = 0L
    return s.indices.sumOf {
        val idx = s[it] - 'a'
        sum += it.toLong() - pos[idx]
        pos[idx] = it
        sum
    }
}