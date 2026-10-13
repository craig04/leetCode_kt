package cn_solution

fun countKConstraintSubstrings(s: String, k: Int): Int {
    val c = IntArray(2)
    var i = 0
    return s.indices.sumOf { j ->
        c[s[j] - '0']++
        while (minOf(c[0], c[1]) > k)
            c[s[i++] - '0']--
        j - i + 1
    }
}