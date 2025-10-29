package cn_solution

fun subarraySum(nums: IntArray, k: Int): Int {
    val pre = hashMapOf(0 to 1)
    var sum = 0
    var ans = 0
    for (n in nums) {
        sum += n
        ans += pre[sum - k] ?: 0
        pre.merge(sum, 1, Int::plus)
    }
    return ans
}