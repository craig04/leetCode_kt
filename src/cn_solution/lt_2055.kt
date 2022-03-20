package cn_solution

fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
    var count = 0
    var index = -1
    val sum = IntArray(s.length)
    val left = IntArray(s.length)
    for (i in s.indices) {
        if (s[i] == '|') index = i else count++
        sum[i] = count
        left[i] = index
    }
    index = -1
    val right = IntArray(s.length)
    for (i in s.indices.reversed()) {
        if (s[i] == '|') index = i
        right[i] = index
    }
    return IntArray(queries.size) {
        val q = queries[it]
        val l = right[q[0]]
        val r = left[q[1]]
        if (l == -1 || l >= r) 0 else sum[r] - sum[l]
    }
}