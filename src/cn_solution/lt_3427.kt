package cn_solution

fun subarraySum(nums: IntArray): Int {
    val pre = IntArray(nums.size + 1)
    nums.forEachIndexed { i, num -> pre[i + 1] = pre[i] + num }
    return nums.indices.sumOf { i -> pre[i + 1] - pre[maxOf(0, i - nums[i])] }
}