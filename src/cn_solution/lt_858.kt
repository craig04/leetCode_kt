package cn_solution

fun mirrorReflection(p: Int, q: Int): Int {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val dis = p * q / gcd(p, q)
    return when {
        dis / q % 2 == 0 -> 2
        else -> dis / p % 2
    }
}