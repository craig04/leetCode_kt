package solution

// result = c[n + 4, 4]
fun countVowelStrings(n: Int): Int {
    val c = intArrayOf(1, 4, 6, 4, 1)
    repeat(n) { (0 until 4).forEach { c[it] += c[it + 1] } }
    return c[0]
}
