package cn_solution

fun canTransform(start: String, end: String): Boolean {
    var i = -1
    var j = -1
    val n = start.length
    while (true) {
        while (++i != n && start[i] != 'X') Unit
        while (++j != n && end[j] != 'X') Unit
        if (i == n && j == n) return true
        if (i == n || j == n) return false
        if (start[i] != end[j]) return false
        if (start[i] == 'L' && i < j) return false
        if (start[j] == 'R' && i > j) return false
    }
}