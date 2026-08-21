package cn_solution

fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
    val cnt = IntArray(n)
    for ((a, b) in roads) {
        cnt[a]++
        cnt[b]++
    }
    cnt.sort()
    return (0 until n).sumOf { (it + 1L) * cnt[it] }
}