package cn_solution

fun maxSubarrayLength(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>()
    var i = 0
    return nums.indices.maxOf { j ->
        val cnt = map.merge(nums[j], 1, Int::plus) ?: 0
        if (cnt > k)
            do {
                map.merge(nums[i], -1, Int::plus)
            } while (nums[i++] != nums[j])
        j - i + 1
    }
}