package cn_solution

import kotlin.math.abs

fun minimumMoves(grid: Array<IntArray>): Int {

    fun IntArray.seq() = first() * 3 + last()
    fun ArrayList<IntArray>.swap(i: Int, j: Int) {
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }

    fun ArrayList<IntArray>.nextPermutation(): Boolean {
        val k = (lastIndex - 1 downTo 0).firstOrNull {
            get(it).seq() < get(it + 1).seq()
        } ?: return false
        for (i in lastIndex downTo k)
            if (get(i).seq() > get(k).seq()) {
                swap(k, i)
                break
            }
        var i = k + 1
        var j = lastIndex
        while (i < j)
            swap(i++, j--)
        return true
    }

    val less = ArrayList<IntArray>()
    val more = ArrayList<IntArray>()
    for (i in 0 until 3)
        for (j in 0 until 3)
            if (grid[i][j] == 0)
                less.add(intArrayOf(i, j))
            else repeat(grid[i][j] - 1) {
                more.add(intArrayOf(i, j))
            }
    more.sortBy { it.seq() }
    var ans = Int.MAX_VALUE
    do {
        ans = minOf(ans, more.indices.sumOf {
            abs(more[it][0] - less[it][0]) + abs(more[it][1] - less[it][1])
        })
    } while (more.nextPermutation())
    return ans
}