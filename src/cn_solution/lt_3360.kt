package cn_solution

fun canAliceWin(n: Int): Boolean {
    var win = false
    var num = 10
    var left = n
    while (left >= num) {
        left -= num--
        win = !win
    }
    return win
}