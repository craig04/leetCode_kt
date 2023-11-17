package cn_solution

fun minimumSteps(s: String): Long {
    var cnt = 0L
    return s.sumOf {
        if (it == '1') {
            cnt++
            0
        } else {
            cnt
        }
    }
}