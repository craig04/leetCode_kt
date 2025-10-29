package cn_solution

fun findMissingElements_hash(nums: IntArray): List<Int> {
    val set = HashSet<Int>()
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (num in nums) {
        set.add(num)
        min = minOf(min, num)
        max = maxOf(max, num)
    }
    return (min until max).filter { it !in set }
}

fun findMissingElements_sort(nums: IntArray): List<Int> {
    nums.sort()
    return (1 until nums.size).flatMap { nums[it - 1] + 1 until nums[it] }
}