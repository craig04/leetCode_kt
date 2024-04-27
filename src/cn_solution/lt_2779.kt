package cn_solution

fun maximumBeauty(nums: IntArray, k: Int): Int {
    nums.sort()
    var i = 0
    return nums.indices.maxOf { j ->
        while (nums[j] - nums[i] > 2 * k)
            i++
        j - i + 1
    }
}