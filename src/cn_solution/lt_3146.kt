package cn_solution

fun findPermutationDifference(s: String, t: String): Int {
    val pos = IntArray(26)
    for (i in s.indices)
        pos[s[i] - 'a'] = i
    return t.indices.sumOf { kotlin.math.abs(it - pos[t[it] - 'a']) }
}