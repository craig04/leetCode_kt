package cn_solution

fun maxRotateFunction(nums: IntArray): Int {
    val n = nums.size
    val sum = nums.sum()
    var f = nums.foldIndexed(0) { v, acc, i -> acc + v * i }
    return (1 until n).fold(f) { acc, i ->
        f += sum - n * nums[n - i]
        maxOf(acc, f)
    }
}