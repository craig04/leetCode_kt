package solution

fun isGoodArray(nums: IntArray): Boolean {
    return nums.reduce { acc, i -> gcd(acc, i) } == 1
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}