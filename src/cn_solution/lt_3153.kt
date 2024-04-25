package cn_solution

fun sumDigitDifferences(nums: IntArray): Long {
    val n = nums.size
    var result = 0L
    while (nums[0] != 0) {
        val cnt = IntArray(10)
        for (i in nums.indices) {
            val idx = nums[i] % 10
            result += i - cnt[idx]
            cnt[idx]++
            nums[i] /= 10
        }
    }
    return result
}