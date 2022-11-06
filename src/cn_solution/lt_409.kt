package cn_solution

private fun longestPalindrome(s: String): Int {
    val count = HashMap<Char, Int>()
    s.forEach { count[it] = (count[it] ?: 0) + 1 }
    val mask = 1.inv()
    val length = count.entries.sumBy { it.value.and(mask) }
    return minOf(length + 1, s.length)
}
