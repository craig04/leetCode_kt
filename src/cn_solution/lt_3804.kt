package cn_solution

fun centeredSubarrays(nums: IntArray): Int {
    val pre = hashMapOf(0 to 1)
    var sum = 0
    var ans = 0
    for (num in nums) {
        sum += num
        ans += pre[sum - num] ?: 0
        pre.merge(sum, 1, Int::plus)
    }
    return ans
}