package cn_solution

fun canChange(start: String, target: String): Boolean {
    val n = start.length
    var i = 0
    var j = 0
    while (true) {
        while (i != n && start[i] == '_')
            i++
        while (j != n && target[j] == '_')
            j++
        if (i == n || j == n)
            break
        val c = start[i]
        if (c != target[j] || (c == 'L' && i < j) || (c == 'R' && i > j))
            return false
        i++
        j++
    }
    return (i until n).all { start[i] == '_' }
            && (j until n).all { target[j] == '_' }
}