package cn_solution

fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
    val cnt = IntArray(nums.size + 1)
    cnt[0] = 1
    var ans = 0
    var sum = 0
    for (num in nums) {
        sum += num
        if (sum - goal >= 0)
            ans += cnt[sum - goal]
        cnt[sum]++
    }
    return ans
}