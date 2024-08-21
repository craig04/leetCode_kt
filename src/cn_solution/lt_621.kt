package cn_solution

fun leastInterval(tasks: CharArray, n: Int): Int {
    var max = 0
    var cat = 0
    val cnt = IntArray(26)
    for (t in tasks) {
        val idx = t - 'A'
        if (++cnt[idx] > max) {
            max = cnt[idx]
            cat = 0
        }
        if (max == cnt[idx])
            cat++
    }
    return maxOf(tasks.size, (max - 1) * (n + 1) + cat)
}