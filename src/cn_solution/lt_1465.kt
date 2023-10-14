package cn_solution

fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
    fun IntArray.cal(end: Int): Long {
        sort()
        var last = 0
        return maxOf(maxOf { (it - last).apply { last = it } }, end - last).toLong()
    }
    return (horizontalCuts.cal(h) * verticalCuts.cal(w) % 1000000007).toInt()
}