package cn_solution

fun minimumReplacement(nums: IntArray): Long {
    var next = 1000000000
    return nums.indices.reversed().sumOf {
        val cur = nums[it]
        val slice = (cur + next - 1) / next
        next = minOf(next, cur / slice)
        slice - 1L
    }
}