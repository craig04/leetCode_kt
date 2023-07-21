package cn_solution

fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
    val end = IntArray(n)
    val prev = Array(n) { ArrayList<Int>() }
    relations.forEach { prev[it[1] - 1].add(it[0] - 1) }
    fun dfs(c: Int): Int {
        if (end[c] == 0) {
            end[c] = prev[c].fold(0) { acc, t -> maxOf(acc, dfs(t)) } + time[c]
        }
        return end[c]
    }
    return (0 until n).fold(0) { res, c -> maxOf(res, dfs(c)) }
}