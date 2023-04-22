package cn_solution

fun longestConsecutive(nums: IntArray): Int {
    val set = nums.toHashSet()
    return set.fold(0) { len, n ->
        maxOf(len, if (n - 1 in set) 0 else (n + 1..Int.MAX_VALUE).first { it !in set } - n)
    }
}