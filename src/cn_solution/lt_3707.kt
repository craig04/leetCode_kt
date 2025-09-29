package cn_solution

fun scoreBalance(s: String): Boolean {
    val sum = s.sumOf { it - 'a' + 1 }
    if (sum % 2 == 1)
        return false
    var pre = 0
    return s.any {
        pre += it - 'a' + 1
        pre * 2 == sum
    }
}