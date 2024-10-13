package cn_solution

fun duplicateNumbersXOR(nums: IntArray): Int {
    var mask = 0L
    var ans = 0
    for (num in nums) {
        val next = 1L shl num or mask
        if (mask == next)
            ans = ans xor num
        mask = next
    }
    return ans
}