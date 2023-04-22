package cn_solution

fun balancedStringSplit(s: String): Int {
    var diff = 0
    return s.count {
        diff += (it - 'O')
        diff == 0
    }
}