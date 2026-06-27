package cn_solution

private fun minFlips(s: String): Int {
    val zero = s.sumOf { '1' - it }
    var one = s.length - zero
    if (s.first() == '1' && s.last() == '1')
        one--
    return minOf(zero, maxOf(0, one - 1))
}