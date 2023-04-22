package cn_solution

fun checkDistances(s: String, distance: IntArray): Boolean {
    return s.indices.all { i ->
        val c = s[i] - 'a'
        val dist = distance[c]
        distance[c] = -distance[c] - 1
        dist < 0 || (dist + i + 1).let { it < s.length && s[it] == s[i] }
    }
}