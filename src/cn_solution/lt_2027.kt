package cn_solution

fun minimumMoves(s: String): Int {
    var i = 0
    var result = 0
    while (i < s.length) {
        if (s[i] == 'X') {
            result++
            i += 3
        } else {
            i++
        }
    }
    return result
}
