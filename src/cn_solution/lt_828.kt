package cn_solution

fun uniqueLetterString(s: String): Int {
    val pos = Array(26) { intArrayOf(-1, -1) }
    return s.indices.sumOf {
        val idx = s[it] - 'A'
        val (a, b) = pos[idx]
        pos[idx][0] = b
        pos[idx][1] = it
        (it - b) * (b - a)
    } + pos.sumOf { (s.length - it[1]) * (it[1] - it[0]) }
}