package cn_solution

fun countOperationsToEmptyArray_BIT(nums: IntArray): Long {
    val n = nums.size
    val a = IntArray(n + 1)
    fun update(i: Int, x: Int) {
        var j = i
        while (j <= n) {
            a[j] += x
            j += j.and(-j)
        }
    }

    fun query(i: Int): Int {
        var res = 0
        var j = i
        while (j > 0) {
            res += a[j]
            j = j.and(j - 1)
        }
        return res
    }
    for (i in 1..n)
        update(i, 1)
    val pos = Array(n) { it }
    pos.sortBy { nums[it] }
    var ans = 0L
    var i = 0
    for (j in pos) {
        ans += query(j + 1) - query(i)
        if (j < i)
            ans += query(n)
        i = j
        update(j + 1, -1)
    }
    return ans
}

fun countOperationsToEmptyArray_math(nums: IntArray): Long {
    val n = nums.size
    val pos = Array(n) { it }
    pos.sortBy { nums[it] }
    var ans = 0L
    for (i in 1 until n)
        if (pos[i] < pos[i - 1])
            ans += n - i
    return ans
}