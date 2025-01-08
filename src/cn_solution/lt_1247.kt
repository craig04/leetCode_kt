package cn_solution

fun minimumSwap(s1: String, s2: String): Int {
    var x = 0
    var y = 0
    for (i in s1.indices) {
        if (s1[i] != s2[i])
            if (s1[i] == 'x')
                x++
            else
                y++
    }
    return if (x + y and 1 == 1) -1 else (x + y) / 2 + x % 2
}