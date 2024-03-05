package cn_solution

fun minOperations(nums: IntArray): Int {
    val unique = nums.toHashSet().toIntArray()
    unique.sort()
    var i = 0
    return unique.indices.minOf { j ->
        val end = unique[j]
        while (end - unique[i] >= nums.size)
            i++
        nums.size - (j - i + 1)
    }
}