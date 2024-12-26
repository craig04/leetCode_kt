package cn_solution

fun maxLength(nums: IntArray): Int {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    var mul = 1
    var l = 0
    return nums.indices.maxOf { r ->
        while (gcd(mul, nums[r]) != 1)
            mul /= nums[l++]
        mul *= nums[r]
        r - l + 1
    }.coerceAtLeast(2)
}