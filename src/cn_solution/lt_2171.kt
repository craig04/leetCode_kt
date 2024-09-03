package cn_solution

fun minimumRemoval(beans: IntArray): Long {
    val cnt = IntArray(100001)
    var take = 0L
    var most = 0
    beans.forEach {
        cnt[it]++
        take += it
        most = maxOf(most, it)
    }
    var more = 0
    return (most downTo 1).minOf {
        take += more - cnt[it] * it.toLong()
        more += cnt[it]
        take
    }
}