package cn_solution

fun maximumSubarrayXor(nums: IntArray, queries: Array<IntArray>): IntArray {
    val n = nums.size
    val x = Array(n) { IntArray(n) }
    val y = Array(n) { IntArray(n) }
    for (j in 0 until n) {
        x[j][j] = nums[j]
        y[j][j] = nums[j]
        for (i in j - 1 downTo 0) {
            x[i][j] = x[i][j - 1] xor x[i + 1][j]
            y[i][j] = maxOf(x[i][j], y[i][j - 1], y[i + 1][j])
        }
    }
    return IntArray(queries.size) { y[queries[it][0]][queries[it][1]] }
}