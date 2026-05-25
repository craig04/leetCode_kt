package cn_solution

fun minChanges(s: String): Int {
    return s.indices.step(2).count { s[it] != s[it + 1] }
}