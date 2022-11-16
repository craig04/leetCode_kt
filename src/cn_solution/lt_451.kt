package cn_solution

fun frequencySort(s: String): String {
    val freq = HashMap<Char, Int>()
    val builder = StringBuilder()
    s.forEach { freq[it] = (freq[it] ?: 0) + 1 }
    freq.entries
        .sortedByDescending { it.value }
        .forEach { e -> repeat(e.value) { builder.append(e.key) } }
    return builder.toString()
}
