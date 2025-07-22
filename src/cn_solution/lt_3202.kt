package cn_solution

private fun maximumLength(nums: IntArray, k: Int): Int {
    val len = Array(k) { IntArray(k) }
    for (num in nums) {
        val y = num % k
        for (x in 0 until k)
            len[x][y] = len[y][x] + 1
    }
    return len.maxOf { it.max() }
}