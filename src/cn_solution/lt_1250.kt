package cn_solution

fun isGoodArray(nums: IntArray): Boolean {
    fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
    return nums.reduce { x, y -> gcd(x, y) } == 1
}