package cn_solution

fun isReachable(targetX: Int, targetY: Int): Boolean {
    fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
    return gcd(targetX, targetY).countOneBits() == 1
}