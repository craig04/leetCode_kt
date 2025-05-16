package cn_solution

fun findGCD(nums: IntArray): Int {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (num in nums) {
        min = minOf(min, num)
        max = maxOf(max, num)
    }
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
    return gcd(min, max)
}