package cn_solution

fun maxSum(nums: List<Int>, k: Int): Int {
    val cnt = IntArray(30)
    for (num in nums)
        for (i in 0 until 30)
            cnt[i] += num shr i and 1
    return (0 until k).fold(0) { ans, _ ->
        var cur = 0L
        for (i in 0 until 30)
            if (cnt[i]-- > 0)
                cur += 1 shl i
        (ans + cur * cur).mod(1000000007)
    }
}