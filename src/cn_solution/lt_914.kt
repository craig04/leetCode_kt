package cn_solution

fun hasGroupsSizeX(deck: IntArray): Boolean {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val map = deck.asSequence().groupingBy { it }.eachCount()
    return map.entries.fold(0) { a, (_, b) -> gcd(a, b) } != 1
}