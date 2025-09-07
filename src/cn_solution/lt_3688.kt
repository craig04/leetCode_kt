package cn_solution

fun evenNumberBitwiseORs(nums: IntArray): Int {
    return nums.fold(0) { ans, num ->
        if (num and 1 == 0) ans or num else ans
    }
}