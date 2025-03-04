package cn_solution

fun solveQueries(nums: IntArray, queries: IntArray): List<Int> {
    val n = nums.size
    val left = IntArray(n) { -1 }
    val right = IntArray(n) { -1 }
    val position = HashMap<Int, IntArray>()
    for (i in nums.indices) {
        val num = nums[i]
        val pos = position.computeIfAbsent(num) { intArrayOf(-1, -1) }
        if (pos[0] == -1) {
            pos.fill(i)
        } else {
            left[i] = i - pos[1]
            right[pos[1]] = left[i]
            right[i] = pos[0] + n - i
            left[pos[0]] = right[i]
            pos[1] = i
        }
    }
    return queries.map { minOf(left[it], right[it]) }
}