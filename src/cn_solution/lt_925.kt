package cn_solution

fun isLongPressedName(name: String, typed: String): Boolean {
    val n = name.length
    val m = typed.length
    var i = 0
    var j = 0
    while (i != n || j != m) {
        if (j == m)
            return false
        if (i != n && name[i] == typed[j]) {
            i++
        } else if (j == 0 || typed[j] != typed[j - 1])
            return false
        j++
    }
    return true
}