package cn_solution

fun findKOr(nums: IntArray, k: Int): Int {
    val cnt = IntArray(31)
    for (n in nums)
        for (i in 0 until 31)
            if (1.shl(i).and(n) != 0)
                cnt[i]++
    return cnt.indices.asSequence()
        .filter { cnt[it] >= k }
        .sumOf { 1.shl(it) }
}