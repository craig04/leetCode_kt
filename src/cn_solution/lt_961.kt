package cn_solution

import kotlin.random.Random

/**
 * Normal solution
 * O(n) time complexity & O(1) space complexity
 */
@Suppress("FunctionName")
fun repeatedNTimes_normal(nums: IntArray): Int {
    for (i in nums.indices step 2)
        if (nums[i] == nums[i + 1])
            return nums[i]
    if (nums[0] == nums[2] || nums[0] == nums[3])
        return nums[0]
    return nums[1]
}

/**
 * Random solution
 * O(1) time complexity in average & O(1) space complexity
 * Infinity time cost in worst case
 */
@Suppress("FunctionName")
fun repeatedNTimes_random(nums: IntArray): Int {
    val random = Random(nums.size)
    while (true) {
        val i = random.nextInt(nums.size)
        val j = random.nextInt(nums.size)
        if (i != j && nums[i] == nums[j])
            return nums[i]
    }
}