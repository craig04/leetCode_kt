package cn_solution

fun canBeValid(s: String, locked: String): Boolean {
    if (s.length % 2 != 0)
        return false
    var min = 0
    var max = 0
    for (i in s.indices) {
        if (locked[i] == '1') {
            val d = if (s[i] == '(') 1 else -1
            min += d
            max += d
            if (max < 0)
                return false
        } else {
            min--
            max++
        }
        if (min < 0)
            min = 1
    }
    return min == 0
}