package cn_solution

fun maxBalancedSubarray(nums: IntArray): Int {
    val n = nums.size
    var xor = 0
    var cnt = n + 0L
    val map = hashMapOf(cnt.shl(32) to -1)
    var ans = 0
    for (i in nums.indices) {
        val num = nums[i]
        xor = xor xor num
        if (num % 2 == 0)
            cnt++
        else
            cnt--
        val key = xor + cnt.shl(32)
        val pre = map.putIfAbsent(key, i)
        if (pre != null)
            ans = maxOf(ans, i - pre)
    }
    return ans
}