package cn_solution

fun minRemoval(nums: IntArray, k: Int): Int {
    nums.sort()
    val n = nums.size
    var j = 1
    return nums.indices.maxOf { i ->
        while (j < n && nums[j] <= nums[i] * 1L * k)
            j++
        n - j + i
    }
}