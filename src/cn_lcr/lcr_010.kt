package cn_lcr

fun subarraySum(nums: IntArray, k: Int): Int {
    val pre = hashMapOf(0 to 1)
    var sum = 0
    var count = 0
    for (n in nums) {
        sum += n
        count += pre[sum - k] ?: 0
        pre[sum] = (pre[sum] ?: 0) + 1
    }
    return count
}