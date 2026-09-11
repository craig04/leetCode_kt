package cn_solution

fun checkValidString(s: String): Boolean {
    var min = 0
    var max = 0
    for (c in s) {
        if (c == '(') {
            ++min
            ++max
        } else if (c == ')') {
            --min
            if (--max < 0)
                return false
        } else {
            --min
            ++max
        }
        min = maxOf(0, min)
    }
    return min == 0
}