package cn_solution

private fun countValidSubstrings(s: String): Long {
    val n = s.length
    var pos = -1
    return (2 until n).fold((n + 1L) * n / 2) { ans, i ->
        if (s[i - 2] == 'a' && s[i - 1] == 'b' && s[i] == 'c')
            pos = i - 2
        ans - pos - 1
    }
}