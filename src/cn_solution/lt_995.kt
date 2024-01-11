package cn_solution

fun minKBitFlips(nums: IntArray, k: Int): Int {
    val n = nums.size
    var flip = 0
    var result = 0
    nums.forEachIndexed { i, num ->
        if (i >= k) {
            flip = nums[i - k] shr 1 xor flip
            nums[i - k] = nums[i - k] and 1
        }
        if (i <= n - k) {
            val cur = flip xor num xor 1
            flip = flip xor cur
            nums[i] = cur shl 1 or num
            result += cur
        } else if (flip xor num == 0) {
            return -1
        }
    }
    return result
}