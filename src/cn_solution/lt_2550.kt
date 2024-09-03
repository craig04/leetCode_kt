package cn_solution

fun monkeyMove(n: Int): Int {
    val modulo = 1000000007
    var pow = 2L
    var ans = 1L
    var t = n
    while (t != 0) {
        if (t and 1 == 1)
            ans = ans * pow % modulo
        pow = pow * pow % modulo
        t /= 2
    }
    return ((ans + modulo - 2) % modulo).toInt()
}