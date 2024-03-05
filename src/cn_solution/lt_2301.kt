package cn_solution

fun matchReplacement(s: String, sub: String, mappings: Array<CharArray>): Boolean {
    val map = HashMap<Char, HashSet<Char>>()
    mappings.forEach { (k, v) -> map.computeIfAbsent(k) { HashSet() }.add(v) }
    return (0..s.length - sub.length).any { i ->
        sub.indices.all { j -> s[i + j] == sub[j] || s[i + j] in (map[sub[j]] ?: emptySet()) }
    }
}