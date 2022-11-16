package cn_solution

fun customSortString(order: String, s: String): String {
    return buildString {
        val freq = IntArray(26)
        s.forEach { freq[it - 'a']++ }
        order.forEach { c ->
            repeat(freq[c - 'a']) { append(c) }
            freq[c - 'a'] = 0
        }
        freq.forEachIndexed { i, n -> repeat(n) { append('a' + i) } }
    }
}
