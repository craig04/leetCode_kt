package cn_solution

fun minSubarray(nums: IntArray, p: Int): Int {
    val remainder = nums.reduce { a, b -> (a + b) % p }
    val map = hashMapOf(0 to -1)
    var prefix = 0
    var result = Int.MAX_VALUE
    for (i in nums.indices) {
        prefix = (prefix + nums[i]) % p
        map[prefix] = i
        val target = (p + prefix - remainder) % p
        map[target]?.also { result = minOf(result, i - it) }
    }
    return if (result >= nums.size) -1 else result
}