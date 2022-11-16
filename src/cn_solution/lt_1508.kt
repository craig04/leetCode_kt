package cn_solution

fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
    val prefix = IntArray(n + 1)
    nums.forEachIndexed { i, a -> prefix[i + 1] = prefix[i] + a }
    val sub = IntArray(n * (n + 1) / 2)
    var idx = 0
    for (i in nums.indices) {
        for (j in i + 1..n) {
            sub[idx++] = prefix[j] - prefix[i]
        }
    }
    sub.sort()
    return (((left - 1 until right).fold(0L) { sum, i -> sum + sub[i] }) % 1000000007).toInt()
}