package cn_solution

fun minOperations(nums: IntArray, k: Int): Int {
    var min = Int.MAX_VALUE
    val set = HashSet<Int>()
    for (num in nums) {
        min = minOf(min, num)
        set.add(num)
    }
    return when {
        k > min -> -1
        k < min -> set.size
        else -> set.size - 1
    }
}