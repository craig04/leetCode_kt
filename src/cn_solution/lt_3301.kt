package cn_solution

fun maximumTotalSum(maximumHeight: IntArray): Long {
    maximumHeight.sortDescending()
    var maximum = Int.MAX_VALUE
    var ans = 0L
    for (height in maximumHeight) {
        val cur = minOf(height, maximum)
        if (cur <= 0)
            return -1
        ans += cur
        maximum = cur - 1
    }
    return ans
}