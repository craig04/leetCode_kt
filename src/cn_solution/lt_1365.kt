package cn_solution

fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val cnt = IntArray(101)
    for (num in nums)
        cnt[num]++
    for (i in 0 until cnt.lastIndex)
        cnt[i + 1] += cnt[i]
    return IntArray(nums.size) { if (nums[it] == 0) 0 else cnt[nums[it] - 1] }
}