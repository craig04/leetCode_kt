package cn_solution

fun winnerOfGame(colors: String): Boolean {
    var cnt = 0
    var a = ' '
    var b = ' '
    for (c in colors) {
        if (a == b && b == c)
            if (a == 'A') cnt++ else cnt--
        a = b
        b = c
    }
    return cnt > 0
}