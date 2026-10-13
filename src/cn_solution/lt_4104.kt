package cn_solution

private fun countValidSubstrings(s: String): Long {
    var (a, ab, abc) = intArrayOf(-1, -1, -1)
    return s.indices.sumOf { i ->
        when (s[i]) {
            'a' -> a = i
            'b' -> ab = a
            'c' -> abc = ab
        }
        i - abc + 0L
    }
}