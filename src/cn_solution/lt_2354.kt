package cn_solution

fun countExcellentPairs(nums: IntArray, k: Int): Long {
    val cnt = LongArray(32)
    val vis = HashSet<Int>()
    for (num in nums)
        if (vis.add(num))
            cnt[num.countOneBits()]++
    var s = 0L
    var j = 31
    return (0..31).sumOf { i ->
        while (j >= 0 && i + j >= k)
            s += cnt[j--]
        cnt[i] * s
    }
}