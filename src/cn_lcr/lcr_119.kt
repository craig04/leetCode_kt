package cn_lcr

fun longestConsecutive(nums: IntArray): Int {
    val s = nums.toHashSet()
    return s.asSequence()
        .filter { it - 1 !in s }
        .maxOfOrNull { n -> (n + 1..Int.MAX_VALUE).first { it !in s } - n } ?: 0
}