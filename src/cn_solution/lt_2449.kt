package cn_solution

fun makeSimilar(nums: IntArray, target: IntArray): Long {
    for (i in nums.indices) {
        if (nums[i] and 1 == 1)
            nums[i] = -nums[i]
        if (target[i] and 1 == 1)
            target[i] = -target[i]
    }
    nums.sort()
    target.sort()
    return nums.indices.sumOf { kotlin.math.abs(nums[it] - target[it]).toLong() } shr 2
}