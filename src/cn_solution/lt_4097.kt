package cn_solution

fun minMergedInteger(nums: IntArray): Int {
    return nums.indices.step(2).minOf { i ->
        var x = nums[i]
        var y = nums[i + 1]
        do {
            x *= 10
            y /= 10
        } while (y != 0)
        x + nums[i + 1]
    }
}