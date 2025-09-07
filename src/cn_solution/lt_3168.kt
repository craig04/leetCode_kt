package cn_solution

fun minimumChairs(s: String): Int {
    var cnt = 0
    return s.maxOf { if (it == 'E') ++cnt else --cnt }
}